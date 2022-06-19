/*
 * package com.ecommerce;
 * 
 * import static org.junit.jupiter.api.Assertions.assertEquals;
 * 
 * import org.junit.jupiter.api.Test; import
 * org.junit.jupiter.api.TestMethodOrder; import
 * org.junit.jupiter.api.MethodOrderer.OrderAnnotation; import
 * org.junit.jupiter.api.Order; import org.junit.runner.RunWith; import
 * org.springframework.beans.factory.annotation.Autowired; import
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
 * com.ecommerce.products.dto.WatchesDto;
 * 
 * @TestMethodOrder(OrderAnnotation.class)
 * 
 * @RunWith(SpringRunner.class)
 * 
 * @SpringBootTest class ProductControllerTest {
 * 
 * @Autowired private ProductsController productController;
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
 * Watches w = new Watches(); WatchesDto wDto = new WatchesDto(); // Laptop {
 * lapDto.setBrand("hp"); lapDto.setModel("pro book"); lapDto.setColor("gray");
 * lapDto.setOs("windows"); lapDto.setSsdCapacity("800");
 * lapDto.setWeight("1kg"); } { lap.setProductId(1L); lap.setBrand("hp");
 * lap.setModel("pro book"); lap.setColor("gray"); lap.setOs("windows");
 * lap.setSsdCapacity("800"); lap.setWeight("1kg"); lap.getProductId(); }
 * 
 * @Order(1)
 * 
 * @Test void saveLaptopTest() { assertEquals(HttpStatus.OK,
 * productController.saveLaptop(lapDto).getStatusCode()); }
 * 
 * @Order(2)
 * 
 * @Test void getAllLaptopsTest() { assertEquals(1,
 * productController.getAllLaptop().size()); }
 * 
 * @Order(3)
 * 
 * @Test void getLaptopByIdTest() { Long id = 1L; assertEquals(HttpStatus.OK,
 * productController.getLaptopById(id).getStatusCode()); }
 * 
 * @Order(4)
 * 
 * @Test void updateLaptopTest() { Long id = 1L; assertEquals(update,
 * productController.updateLaptop(lapDto, id).getBody()); }
 * 
 * @Order(5)
 * 
 * @Test void deleteLaptopTest() { Long id = 1L; assertEquals(del,
 * productController.deleteLaptop(id).getBody()); }
 * 
 * // watches
 * 
 * {
 * 
 * wDto.setBrand("jdj"); wDto.setColor("blue");
 * wDto.setConnectorType("blue tooth"); wDto.setModel("wygdd");
 * wDto.setStyle("band"); wDto.setWaterRessistent(false); } {
 * w.setProductId(1L); w.setBrand("csk"); w.setColor("blue");
 * w.setConnectorType("bluetooth"); w.setModel("band"); w.setStyle("bghs");
 * w.setWaterRessistent(false); w.getProductId(); }
 * 
 * @Order(6)
 * 
 * @Test void saveWatchesTest() { assertEquals(HttpStatus.OK,
 * productController.saveWatches(wDto).getStatusCode()); }
 * 
 * @Order(7)
 * 
 * @Test void getAllWatchesTest() { assertEquals(1,
 * productController.getAllWatches().size()); }
 * 
 * @Order(8)
 * 
 * @Test void getWatchByIdTest() { Long id = 1L; assertEquals(HttpStatus.OK,
 * productController.getWatchesById(id).getStatusCode()); }
 * 
 * @Order(9)
 * 
 * @Test void updateWatchesTest() { Long id = 1L; assertEquals(update,
 * productController.updateWatches(wDto, id).getBody()); }
 * 
 * @Order(10)
 * 
 * @Test void deleteWatchesTest() { Long id = 1L; assertEquals(del,
 * productController.deleteWatch(id).getBody()); }
 * 
 * // Mobile
 * 
 * { mDto.setBattery("5600maph"); mDto.setBrand("redmi"); mDto.setColor("blue");
 * mDto.setModel("POCO X3"); mDto.setProcessor("snap dragon");
 * mDto.setRam("4GB"); } { m.setProductId(1L); m.setBattery("4r53");
 * m.setBrand("poco"); m.setColor("lue"); m.setModel("redmi");
 * m.setProcessor("android"); m.setRam("4"); m.getProductId(); }
 * 
 * @Order(11)
 * 
 * @Test void saveMobileTest() { assertEquals(HttpStatus.OK,
 * productController.saveMobile(mDto).getStatusCode()); }
 * 
 * @Order(12)
 * 
 * @Test void getAllMobilesTest() { assertEquals(1,
 * productController.getAllMobile().size());
 * 
 * }
 * 
 * @Order(13)
 * 
 * @Test void getMobileByIdTest() { Long id = 1L; assertEquals(HttpStatus.OK,
 * productController.getMobileById(id).getStatusCode()); }
 * 
 * @Order(14)
 * 
 * @Test void updateMobileTest() { Long id = 1L; assertEquals(update,
 * productController.updateMobile(mDto, id).getBody());
 * 
 * }
 * 
 * @Order(15)
 * 
 * @Test void deleteMobileTest() { Long id = 1L; assertEquals(del,
 * productController.deleteMobile(id).getBody()); }
 * 
 * // TV
 * 
 * { tvDto.setBrand("LG"); tvDto.setColor("black"); tvDto.setModel("ghy");
 * tvDto.setSmartTv("no"); } { tv.setProductId(1L); tv.setBrand("samsung");
 * tv.setColor("red"); tv.setModel("mi 45r"); tv.setSmartTv("yes");
 * tv.getProductId(); }
 * 
 * @Order(16)
 * 
 * @Test void saveTvTest() { assertEquals(HttpStatus.OK,
 * productController.saveTv(tvDto).getStatusCode()); }
 * 
 * @Order(17)
 * 
 * @Test void getAllTvsTest() { assertEquals(1,
 * productController.getTv().size()); }
 * 
 * @Order(18)
 * 
 * @Test void getTvByIdTest() { Long id=1L; assertEquals(HttpStatus.OK,
 * productController.getTvById(id).getStatusCode()); }
 * 
 * @Order(19)
 * 
 * @Test void updateTvTest() { Long id = 1L; assertEquals(update,
 * productController.updateTv(tvDto, id).getBody());
 * 
 * }
 * 
 * 
 * @Order(20)
 * 
 * @Test void deleteTvTest() { Long id = 1L; assertEquals(del,
 * productController.deleteTv(id).getBody()); }
 * 
 * }
 */