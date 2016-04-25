public class Parcel{

  private int width;
  private int depth;
  private int height;
  private int weight;



  public Parcel(int inWidth, int inDepth, int inHeight, int inWeight){
    width = inWidth;
    depth = inDepth;
    height = inHeight;
    weight = inWeight;
  }

  public String volume(){
    // return w*d*h (store as size?)
    Integer size = width * depth * height;
    String outSize = Integer.toString(size);
    return outSize;
  }

  public String costToShip(){
    // returns Cost based on size and weight
    return Integer.toString((weight * 5) + (Integer.parseInt(volume()) * 2) );
  }

  //gift wrapping method, height*depth*2 width*depth*2 width*height*2, return added cost.
  public String addWrapping(){
    return Integer.toString((height*depth*2) + (width*depth*2) + (width*height*2));
  }
}
