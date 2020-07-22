package me.giverplay.minigames.graphics;

import java.awt.Color;

import org.bukkit.Material;

public enum Colors
{
	// B/W
	C_0_0_0			  (Material.BLACK_CONCRETE, 						new Color(0, 0, 0)),
	C_19_19_19	  (Material.COAL_BLOCK, 								new Color(19, 19, 19)),
	C_39_39_39	  (Material.BLACK_WOOL, 							  new Color(39, 39, 39)),
	C_59_59_59	  (Material.BLACK_CONCRETE_POWDER, 		  new Color(59, 59, 59)),
	C_78_78_78	  (Material.GRAY_CONCRETE, 			   		  new Color(78, 78, 78)),
	C_98_98_98	  (Material.GRAY_WOOL, 								  new Color(98, 98, 98)),
	C_117_117_117 (Material.GRAY_CONCRETE_POWDER, 			new Color(117, 117, 117)),
	C_137_137_137 (Material.CYAN_TERRACOTTA, 					  new Color(137, 137, 137)),
	C_157_157_157 (Material.LIGHT_GRAY_CONCRETE, 			  new Color(157, 157, 157)),
	C_176_176_176 (Material.LIGHT_GRAY_WOOL, 				    new Color(176, 176, 176)),
	C_196_196_196 (Material.LIGHT_GRAY_CONCRETE_POWDER, new Color(196, 196, 196)),
	C_216_216_216 (Material.WHITE_CONCRETE,						  new Color(216, 216, 216)),
	C_235_235_235 (Material.WHITE_WOOL, 								new Color(235, 235, 235)),
	C_255_255_255 (Material.WHITE_CONCRETE_POWDER, 		  new Color(255, 255, 255)),
	
	// Brown
	C_30_20_15		(Material.BLACK_TERRACOTTA, 		 new Color(30, 20, 15)),
	C_50_35_35		(Material.GRAY_TERRACOTTA, 			 new Color(50, 35, 35)),
	C_65_45_35		(Material.BROWN_TERRACOTTA, 		 new Color(65, 45, 35)),
	C_80_50_30		(Material.BROWN_CONCRETE, 		   new Color(80, 50, 30)),
	C_105_65_45		(Material.BROWN_WOOL, 					 new Color(105, 65, 45)),
	C_115_80_60  	(Material.BROWN_CONCRETE_POWDER, new Color(115, 80, 60)),
	C_110_90_90	  (Material.LIGHT_GRAY_TERRACOTTA, new Color(110, 90, 90)),
	C_170_145_150 (Material.WHITE_TERRACOTTA,    	 new Color(170, 145, 150)),
	
	// Orange
	C_135_70_35	 (Material.ORANGE_TERRACOTTA, 		 new Color(135, 70, 35)),
	C_180_80_0	 (Material.ORANGE_CONCRETE, 			 new Color(180, 80, 0)),
	C_200_120_40 (Material.ORANGE_WOOL, 				   new Color(200, 120, 40)),
	C_190_140_70 (Material.ORANGE_CONCRETE_POWDER, new Color(190, 140, 70)),
	
	// Yellow
	C_150_110_35 (Material.YELLOW_TERRACOTTA, 		 new Color(150, 110, 35)),
	C_195_140_20 (Material.YELLOW_CONCRETE, 			 new Color(195, 140, 20)),
	C_200_160_35 (Material.YELLOW_WOOL, 					 new Color(200, 160, 35)),
	C_190_175_75 (Material.YELLOW_CONCRETE_POWDER, new Color(190, 175, 75)),
	
	// Green
	C_60_65_40  (Material.GREEN_TERRACOTTA, 		 new Color(60, 65, 40)),
	C_60_75_35  (Material.GREEN_CONCRETE, 			 new Color(60, 75, 35)),
	C_75_100_20 (Material.LIME_TERRACOTTA, 			 new Color(75, 100, 20)),
	C_80_95_40  (Material.GREEN_WOOL, 					 new Color(80, 95, 40)),
	C_90_100_50 (Material.GREEN_CONCRETE_POWDER, new Color(90, 100, 50)),
	
	// Lime
	C_80_140_25  (Material.LIME_CONCRETE, 			 new Color(80, 140, 25)),
	C_95_155_25  (Material.LIME_WOOL, 					 new Color(95, 155, 25)),
	C_115_166_40 (Material.LIME_CONCRETE_POWDER, new Color(115, 166, 40)),
	
	// Dark blue
	C_35_35_135 (Material.BLUE_CONCRETE, 				new Color(35, 35, 135)),
	C_40_40_140 (Material.BLUE_WOOL, 						new Color(40, 40, 140)),
	C_50_55_145 (Material.BLUE_CONCRETE_POWDER, new Color(50, 55, 145)),
	
	// Blue
	C_20_100_130 (Material.CYAN_CONCRETE, 			 new Color(20, 100, 130)),
	C_20_125_145 (Material.CYAN_WOOL, 					 new Color(20, 125, 145)),
	C_30_127_150 (Material.CYAN_CONCRETE_POWDER, new Color(30, 127, 150)),
	
	// Light blue
	C_30_110_185 (Material.LIGHT_BLUE_CONCRETE, 			 new Color(30, 110, 185)),
	C_45_140_200 (Material.LIGHT_BLUE_WOOL, 				   new Color(45, 140, 200)),
	C_90_180_225 (Material.LIGHT_BLUE_CONCRETE_POWDER, new Color(90, 180, 225)),
	
	// Red
	C_115_25_30 (Material.RED_CONCRETE, 			 new Color(115, 25, 30)),
	C_125_30_30 (Material.RED_WOOL, 					 new Color(125, 30, 30)),
	C_150_50_50 (Material.RED_CONCRETE_POWDER, new Color(150, 50, 50)),
	C_115_50_40 (Material.RED_TERRACOTTA, 		 new Color(115, 50, 40)),
	C_130_65_75 (Material.PINK_TERRACOTTA, 		 new Color(130, 65, 75)),
	
	// Purple
	C_60_50_85   (Material.BLUE_TERRACOTTA,  			 new Color(60, 50, 85)),
	C_80_25_145  (Material.PURPLE_CONCRETE, 			 new Color(80, 25, 145)),
	C_105_35_165 (Material.PURPLE_WOOL,			       new Color(105, 35, 165)),
	C_125_60_180 (Material.PURPLE_CONCRETE_POWDER, new Color(125, 60, 180)),
	
	// Pink
	C_95_55_80    (Material.PURPLE_TERRACOTTA, 		new Color(95, 55, 80)),
	C_120_70_100  (Material.MAGENTA_TERRACOTTA, 	new Color(120, 70, 100)),
	C_175_80_135  (Material.PINK_CONCRETE, 			  new Color(175, 80, 135)),
	C_190_105_150 (Material.PINK_WOOL, 					  new Color(190, 105, 150)),
	C_185_135_175 (Material.PINK_CONCRETE_POWDER, new Color(185, 135, 175)),
	
	// Pink and purple
	C_140_40_150 (Material.MAGENTA_CONCRETE, 				new Color(140, 40, 150)),
	C_150_50_160 (Material.MAGENTA_WOOL,         		new Color(150, 50, 160)),
	C_180_90_200 (Material.MAGENTA_CONCRETE_POWDER, new Color(180, 90, 200)),
	
	;
	
	private Material material;
	private Color color;
	
	private Colors(Material material, Color color)
	{
		this.material = material;
	}
	
	public Color getColor()
	{
		return this.color;
	}
	
	public Material getMaterial()
	{
		return this.material;
	}
}
