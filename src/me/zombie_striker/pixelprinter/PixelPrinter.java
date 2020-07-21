/*
 *  Copyright (C) 2017 Zombie_Striker
 *
 *  This program is free software; you can redistribute it and/or modify it under the terms of the
 *  GNU General Public License as published by the Free Software Foundation; either version 2 of
 *  the License, or (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 *  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *  See the GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License along with this program;
 *  if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA
 *  02111-1307 USA
 */
package me.zombie_striker.pixelprinter;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.zombie_striker.pixelprinter.data.Direction;
import me.zombie_striker.pixelprinter.data.FileCreatorData;
import me.zombie_striker.pixelprinter.util.AsyncImageHolder;
import me.zombie_striker.pixelprinter.util.GifHolder;
import me.zombie_striker.pixelprinter.util.MapWallUtil;
import me.zombie_striker.pixelprinter.util.RGBBlockColor;
import me.zombie_striker.pixelprinter.util.RGBBlockColor.Pixel;

public class PixelPrinter extends JavaPlugin {

	public static boolean isAbove113 = false;
	private static PixelPrinter instance;
	public Map<UUID, FileCreatorData> downloadFile = new HashMap<UUID, FileCreatorData>();

	public List<GifHolder> gifs = new ArrayList<GifHolder>();
	public int loadCount = 500;
	public Material[] supportedMaterials = null;
	File images = null;
	File resoucepackFolder = null;
	private String prefix = ChatColor.DARK_PURPLE + "[PixelPrinter]" + ChatColor.WHITE;

	public static PixelPrinter getInstance() {
		return instance;
	}

	public static void saveImage(URL url, File file) throws IOException {
		InputStream is = url.openStream();
		file.getParentFile().mkdirs();
		file.createNewFile();
		OutputStream os = new FileOutputStream(file);

		byte[] b = new byte[2048];
		int length;

		while ((length = is.read(b)) != -1) {
			os.write(b, 0, length);
		}
		is.close();
		os.close();
	}

	public String getPrefix() {
		return prefix;
	}

	public void createMap(Direction dir, Player p, BufferedImage bi2, int height) {
		BufferedImage bi = RGBBlockColor.resize(bi2,
				(int) (bi2.getWidth() * (((double) height) * 128 / bi2.getHeight())), height * 128);
		// createResizedCopy(bi2, height * 128, true);
		BufferedImage[] images = new BufferedImage[1];
		images[0] = bi;
		createMapAnim(dir, p, images, height);
	}

	public void createMapAnim(Direction dir, Player p, BufferedImage[] bi2, int height) {
		ItemStack[][] im = MapWallUtil.getMaps(bi2);
		for (int x = 0; x < im.length; x++) {
			for (int y = 0; y < im[x].length; y++) {
				MapWallUtil.setBlockAt(dir, p, y, x, im[x][(im[x].length - 1) - y]);
			}
		}
	}

	public void createImage(Player p, BufferedImage bi, String dir, int height, boolean enableTrans, String name) {
		bi = RGBBlockColor.resize(bi, (int) (bi.getWidth() * (((double) height) * 2 / bi.getHeight())), height * 2);
		Pixel[][] result = RGBBlockColor.convertTo2DWithoutUsingGetRGB(bi);
		final Location loc1 = p.getLocation().clone();
		if (Direction.getDir(dir) == null) {
			p.sendMessage(prefix + " You must provide a valid direction.");
			return;
		}
		new AsyncImageHolder(name, result, p, loc1, Direction.getDir(dir), bi, enableTrans).loadImage(true);
	}

	public void createGif(String[] args, final Location loc, int height, final String dir, final Player p) {
		try {
			final GifHolder gif = new GifHolder(args[2], loc, height, dir, p.getUniqueId());
			if (Direction.getDir(dir) == null) {
				p.sendMessage(prefix + " You must provide a valid direction.");
				return;
			}
			new BukkitRunnable() {
				public void run() {
					if (gif.getFrames() == null || gif.getFrames().length < 1)
						return;
					new BukkitRunnable() {
						public void run() {
							gif.init();
							gifs.add(gif);
							p.sendMessage(getPrefix() + " Added a new Gif. The gif's ID is " + gif.getID() + " with "
									+ gif.getSize() + " frames.");
						}
					}.runTaskLater(PixelPrinter.getInstance(), 5);
					cancel();
				}
			}.runTaskTimer(this, 0, 5);
		} catch (Exception e) {
			p.sendMessage(getPrefix() + " Something failed. Please check console for more details.");
			e.printStackTrace();
		}
	}

	public File getImageFile() {
		return this.images;
	}
}
