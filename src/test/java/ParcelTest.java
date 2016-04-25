

import org.junit.*;
import static org.junit.Assert.*;

public class ParcelTest{

  @Test
  public void newParcel_instantiates_true(){
    Parcel testParcel = new Parcel(1,1,1,0);
    assertEquals(true, testParcel instanceof Parcel);
  }

  @Test
  public void newParcel_volumeReturnsDimensionsMultiplied_true(){
    Parcel testParcel = new Parcel(2,2,2,0);
    assertEquals("8", testParcel.volume());
  }
  @Test
  public void newParcel_volumeReturnsCosttoShip_true(){
    Parcel testParcel = new Parcel(2,2,2,2);
    assertEquals("26", testParcel.costToShip());
  }

}
