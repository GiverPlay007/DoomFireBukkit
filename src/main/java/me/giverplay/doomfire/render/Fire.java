package me.giverplay.doomfire.render;

import org.bukkit.Material;

// Java implementation by https://github.com/AkiraGustavoMinami
public class Fire
{
  // Limitezinhos
  private final Material[] colorArray = new Material[] {
          Material.SNOW_BLOCK,
          Material.WHITE_WOOL,
          Material.SMOOTH_QUARTZ,
          Material.WHITE_CONCRETE,
          Material.IRON_BLOCK,
          Material.YELLOW_WOOL,
          Material.YELLOW_WOOL,
          Material.YELLOW_CONCRETE,
          Material.YELLOW_CONCRETE,
          Material.YELLOW_CONCRETE,
          Material.YELLOW_CONCRETE,
          Material.ORANGE_CONCRETE_POWDER,
          Material.ORANGE_CONCRETE_POWDER,
          Material.ORANGE_CONCRETE_POWDER,
          Material.ORANGE_CONCRETE_POWDER,
          Material.ORANGE_CONCRETE,
          Material.ORANGE_CONCRETE,
          Material.ORANGE_CONCRETE,
          Material.ORANGE_CONCRETE,
          Material.RED_WOOL,
          Material.RED_WOOL,
          Material.RED_CONCRETE,
          Material.RED_CONCRETE,
          Material.NETHER_WART_BLOCK,
          Material.NETHER_WART_BLOCK,
          Material.BLACK_WOOL,
          Material.BLACK_WOOL,
          Material.BLACK_WOOL,
          Material.BLACK_WOOL,
          Material.BLACK_CONCRETE,
          Material.BLACK_CONCRETE,
          Material.BLACK_CONCRETE,
          Material.BLACK_CONCRETE,
  };

  private int[] firePixelsArray;

  protected int fireWidth = 1;
  protected int fireHeight = 1;

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
      this.firePixelsArray[pixelIndex] = 36;
    }
  }
}