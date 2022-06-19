/*
 * package com.ecommerce;
 * 
 * import static org.junit.jupiter.api.Assertions.assertEquals; import static
 * org.mockito.Mockito.when;
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * import org.junit.jupiter.api.Test; import org.junit.runner.RunWith; import
 * org.mockito.InjectMocks; import org.mockito.Mock; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.test.context.junit4.SpringRunner;
 * 
 * import com.ecommerce.controller.ProductsController; import
 * com.ecommerce.model.Laptop; import com.ecommerce.model.Mobile; import
 * com.ecommerce.model.Tv; import com.ecommerce.model.Watches; import
 * com.ecommerce.products.dto.LaptopDto; import
 * com.ecommerce.products.dto.MobileDto; import
 * com.ecommerce.products.dto.TvDto; import
 * com.ecommerce.products.dto.WatchesDto; import
 * com.ecommerce.service.LaptopService; import
 * com.ecommerce.service.MobileService; import com.ecommerce.service.TvService;
 * import com.ecommerce.service.WatchesService;
 * 
 * @RunWith(SpringRunner.class)
 * 
 * @SpringBootTest(classes = { ProductsControllerTest.class }) class
 * ProductsControllerTest {
 * 
 * @InjectMocks private ProductsController productController;
 * 
 * @Mock private WatchesService watchService;
 * 
 * @Mock private MobileService mobileService;
 * 
 * @Mock private LaptopService lapService;
 * 
 * @Mock private TvService tvService;
 * 
 * String update = "Product Updated Successfully"; String del =
 * "product deleted successfully";
 * 
 * Laptop lap = new Laptop(); LaptopDto lapDto = new LaptopDto();
 * 
 * Mobile m = new Mobile(); MobileDto mDto = new MobileDto();
 * 
 * Tv tv = new Tv(); TvDto tvDto = new TvDto();
 * 
 * Watches w = new Watches(); WatchesDto wDto = new WatchesDto();
 * 
 * // Laptop { lapDto.setBrand("hp"); lapDto.setModel("pro book");
 * lapDto.setColor("gray");lapDto.setOs("windows");lapDto.setSsdCapacity("800");
 * lapDto.setWeight("1kg");
 * }{lap.setProductId(1L);lap.setBrand("hp");lap.setModel("pro book");lap.
 * setColor("gray");lap.setOs("windows");lap.setSsdCapacity("800");lap.setWeight
 * ("1kg");lap.getProductId();}
 * 
 * @Test void saveWatchesTest() { WatchesDto w = new WatchesDto();
 * assertEquals(HttpStatus.OK,
 * productController.saveWatches(w).getStatusCode()); }
 * 
 * @Test void getAllWatchesTest() { List<Watches> watch = new ArrayList<>();
 * watch.add(new Watches(1L, "boat", "SHR44", "Black", "JGJ", "BlueTooth",
 * true)); watch.add(new Watches(1L, "MI", "SHR44", "white", "JGJ", "BlueTooth",
 * true)); when(watchService.getAllWatches()).thenReturn(watch); assertEquals(2,
 * productController.getAllWatches().size()); }
 * 
 * @Test void getWatchByIdTest() { Long id = 1L; Watches w = new Watches(1L,
 * "boat", "SHR44", "Black", "JGJ", "BlueTooth", true);
 * when(watchService.getWatchesById(id)).thenReturn(w);
 * assertEquals(HttpStatus.OK,
 * productController.getWatchesById(id).getStatusCode()); }
 * 
 * @Test void deleteWatchesTest() { Long id = 1L;
 * watchService.deleteWatches(id); assertEquals(del,
 * productController.deleteWatch(id).getBody()); }
 * 
 * @Test void updateWatchesTest() { Long id = 1L; WatchesDto w = new
 * WatchesDto(); when(watchService.updateWatches(w, id)).thenReturn(w);
 * assertEquals(update, productController.updateWatches(w, id).getBody());
 * 
 * }
 * 
 * @Test void saveLaptopTest() { assertEquals(HttpStatus.OK,
 * productController.saveLaptop(lapDto).getStatusCode()); }
 * 
 * @Test void getAllLaptopsTest() { List<Laptop> lap = new ArrayList<>();
 * lap.add(new Laptop(1L, "Samsung", "idea pad", "black", "800 gb", "windows",
 * "1.5 kg")); lap.add(new Laptop(2L, "Lenovo", "idea pad", "black", "800 gb",
 * "windows", "1.5 kg")); when(lapService.getAllLaptop()).thenReturn(lap);
 * assertEquals(2, productController.getAllLaptop().size()); }
 * 
 * @Test void getLaptopByIdTest() { Long id = 1L; Laptop lap = new Laptop(1L,
 * "Samsung", "idea pad", "black", "800 gb", "windows", "1.5 kg");
 * when(lapService.getLaptopById(id)).thenReturn(lap);
 * assertEquals(HttpStatus.OK,
 * productController.getLaptopById(id).getStatusCode()); }
 * 
 * @Test void deleteLaptopTest() { Long id = 1L; lapService.deleteLaptop(id);
 * 
 * assertEquals(del, productController.deleteLaptop(id).getBody()); }
 * 
 * @Test void updateLaptopTest() { Long id = 1L; LaptopDto lap = new
 * LaptopDto(); when(lapService.updateLaptop(lap, id)).thenReturn(lap);
 * assertEquals(update, productController.updateLaptop(lap, id).getBody());
 * 
 * }
 * 
 * @Test void saveMobileTest() { MobileDto mobile = new MobileDto();
 * assertEquals(HttpStatus.OK,
 * productController.saveMobile(mobile).getStatusCode()); }
 * 
 * @Test void getAllMobilesTest() { List<Mobile> mobile = new ArrayList<>();
 * mobile.add(new Mobile(1L, "redmi", "POCO X3", "blue", "4gb", "intel",
 * "4500mah")); mobile.add(new Mobile(2L, "vivo", "Z1 pro", "black", "4gb",
 * "intel", "4500mah")); when(mobileService.getAllMobiles()).thenReturn(mobile);
 * assertEquals(2, productController.getAllMobile().size());
 * 
 * }
 * 
 * @Test void getMobileByIdTest() { Long id = 1L; Mobile m = new Mobile(1L,
 * "redmi", "POCO X3", "blue", "4gb", "intel", "4500mah");
 * when(mobileService.getMobileById(id)).thenReturn(m);
 * assertEquals(HttpStatus.OK,
 * productController.getMobileById(id).getStatusCode()); }
 * 
 * @Test void deleteMobileTest() { Long id = 1L; mobileService.deleteMobile(id);
 * 
 * assertEquals(del, productController.deleteMobile(id).getBody()); }
 * 
 * @Test void updateMobileTest() { Long id = 1L; MobileDto mobile = new
 * MobileDto(); when(mobileService.updateMobile(mobile, id)).thenReturn(mobile);
 * assertEquals(update, productController.updateMobile(mobile, id).getBody());
 * 
 * }
 * 
 * @Test void saveTvTest() { TvDto tv = new TvDto(); assertEquals(HttpStatus.OK,
 * productController.saveTv(tv).getStatusCode()); }
 * 
 * @Test void getAllTvsTest() { List<Tv> tv = new ArrayList<>(); tv.add(new
 * Tv(1L, "LG", "LG567", "gray", "yes")); tv.add(new Tv(2L, "samsung", "LG567",
 * "gray", "yes")); when(tvService.getAllTvs()).thenReturn(tv); assertEquals(2,
 * productController.getTv().size()); }
 * 
 * @Test void getTvByIdTest() { Long id = 1L; Tv tv = new Tv(1L, "LG", "LG567",
 * "gray", "yes"); when(tvService.getTvById(id)).thenReturn(tv);
 * assertEquals(HttpStatus.OK, productController.getTvById(id).getStatusCode());
 * }
 * 
 * @Test void deleteTvTest() { Long id = 1L; tvService.deleteTv(id);
 * 
 * assertEquals(del, productController.deleteTv(id).getBody()); }
 * 
 * @Test void updateTvTest() { Long id = 1L; TvDto tv = new TvDto();
 * when(tvService.updateTv(tv, id)).thenReturn(tv); assertEquals(update,
 * productController.updateTv(tv, id).getBody());
 * 
 * } }
 */