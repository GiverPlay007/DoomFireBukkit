package me.giverplay.doomfire.render;

import org.bukkit.Material;

// Java implementation by https://github.com/AkiraGustavoMinami
public class Fire
{
  private final Material[] colorArray;

  private int[] firePixelsArray;

  protected int fireWidth = 0;
  protected int fireHeight = 0;

  public void start(int width, int height)
  {
    fireWidth = width;
    fireHeight = height;

    createFireDataStructure();
    createFireSource();
  }

  private void createFireDataStructure()
  {
    int numberOfPixels = this.fireWidth * this.fireHeight;

    this.firePixelsArray = new int[numberOfPixels];

    for(int i = 0; i < numberOfPixels; i++)
    {
      this.firePixelsArray[i] = 0;
    }
  }

  public void calculateFirePropagation()
  {
    for(int column = 0; column < this.fireWidth; column++)
    {
      for(int row = 0; row < this.fireHeight; row++)
      {
        int pixelIndex = column + this.fireWidth * row;
        updateFireIntensityPerPixel(pixelIndex);
      }
    }
  }

  private void updateFireIntensityPerPixel(int currentPixelIndex)
  {
    int belowPixelIndex = currentPixelIndex + this.fireWidth;

    if(belowPixelIndex >= this.fireWidth * this.fireHeight)
      return;

    int decay = (int) Math.floor(Math.random() * 3.0D);
    int belowPixelFireIntensity = this.firePixelsArray[belowPixelIndex];
    int newFireIntensity = Math.max(belowPixelFireIntensity - decay, 0);

    if(currentPixelIndex - decay > 0)
      this.firePixelsArray[currentPixelIndex - decay] = newFireIntensity;
  }

  public void renderFire(Material[] materialArray)
  {
    for(int row = 0; row < this.fireHeight; row++)
    {
      for(int column = 0; column < this.fireWidth; column++)
      {
        int pixelIndex = column + this.fireWidth * row;
        Material pixelColor = this.colorArray[this.firePixelsArray[pixelIndex]];
        materialArray[pixelIndex] = pixelColor;
      }
    }
  }

  private void createFireSource()
  {
    for(int column = 0; column < this.fireWidth; column++)
    {
      int overFlowPixelIndex = this.fireWidth * this.fireHeight;
      int pixelIndex = overFlowPixelIndex - this.fireWidth + column;
      this.firePixelsArray[pixelIndex] = 13;
    }
  }

  {
    colorArray = new Material[14];

    colorArray[0] = Material.BLACK_CONCRETE;
    colorArray[1] = Material.BLACK_WOOL;
    colorArray[2] = Material.NETHER_WART_BLOCK;
    colorArray[3] = Material.RED_CONCRETE;
    colorArray[4] = Material.RED_WOOL;
    colorArray[5] = Material.ORANGE_CONCRETE;
    colorArray[6] = Material.ORANGE_CONCRETE_POWDER;
    colorArray[7] = Material.YELLOW_CONCRETE;
    colorArray[8] = Material.YELLOW_WOOL;
    colorArray[9] = Material.IRON_BLOCK;
    colorArray[10] = Material.WHITE_CONCRETE;
    colorArray[11] = Material.SMOOTH_QUARTZ;
    colorArray[12] = Material.WHITE_WOOL;
    colorArray[13] = Material.SNOW_BLOCK;
  }
}