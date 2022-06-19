package com.ecommerce;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import com.ecommerce.controller.ProductsController;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.model.Laptop;
import com.ecommerce.model.Mobile;
import com.ecommerce.model.Tv;
import com.ecommerce.model.Watches;
import com.ecommerce.products.dto.LaptopDto;
import com.ecommerce.products.dto.MobileDto;
import com.ecommerce.products.dto.TvDto;
import com.ecommerce.products.dto.WatchesDto;
import com.ecommerce.service.LaptopService;
import com.ecommerce.service.MobileService;
import com.ecommerce.service.TvService;
import com.ecommerce.service.WatchesService;

@TestMethodOrder(OrderAnnotation.class)
@RunWith(SpringRunner.class)
@SpringBootTest
class ProductsTest {
	@Autowired
	private LaptopService lapService;

	@Autowired
	private MobileService mobileService;

	@Autowired
	private TvService tvService;

	@Autowired
	private WatchesService watchService;
	@Autowired
	private ProductsController productController;
	
	String update = "Product Updated Successfully";
	String del = "product deleted successfully";

	Laptop lap = new Laptop();
	LaptopDto lapDto = new LaptopDto();

	Mobile m = new Mobile();
	MobileDto mDto = new MobileDto();

	Tv tv = new Tv();
	TvDto tvDto = new TvDto();

	Watches w = new Watches();
	WatchesDto wDto = new WatchesDto();

	{
		lapDto.setBrand("hp");
		lapDto.setModel("pro book");
		lapDto.setColor("gray");
		lapDto.setOs("windows");
		lapDto.setSsdCapacity("800");
		lapDto.setWeight("1kg");
	}
	{
		lapDto.getBrand();
		lapDto.getColor();
		lapDto.getModel();
		lapDto.getOs();
		lapDto.getSsdCapacity();
		lapDto.getWeight();
	}
	{
		// lap.setProductId(1L);
		lap.setBrand("hp");
		lap.setModel("pro book");
		lap.setColor("gray");
		lap.setOs("windows");
		lap.setSsdCapacity("800");
		lap.setWeight("1kg");
	}
	{
		{
			lap.getBrand();
			lap.getColor();
			lap.getModel();
			lap.getOs();
			lap.getSsdCapacity();
			lap.getWeight();
			lap.getProductId();
		}
	}
	@Order(1)
	@Test
	void saveLaptopTest() {

		assertEquals("Product saved successfully", lapService.saveLaptop(lapDto));
	}

	@Order(2)
	@Test
	void getAllLaptopsTest() {
		assertEquals(1, lapService.getAllLaptop().size());
	}

	@Order(3)
	@Test
	void getLaptopByIdTest() {
		Long id = 1L;
		assertEquals(1, lapService.getLaptopById(id).getProductId());
	}

	@Order(4)
	@Test
	void getLaptopByIdFail() {

		Long id = 20L;
		assertThrows(ResourceNotFoundException.class, () -> lapService.getLaptopById(id),
				"user not found with userId : " + id + "");

	}

	@Order(5)
	@Test
	void updateLaptopTest() {
		Long id = 1L;
		assertEquals("Product Updated Successfully", lapService.updateLaptop(lapDto, id));

	}

	@Order(6)

	@Test
	void updateLaptopTestFail() {
		Long id = 20L;
		assertThrows(ResourceNotFoundException.class, () -> lapService.updateLaptop(lapDto, id),
				"user not found with userId : " + id + "");
	}

	@Order(7)

	@Test
	void deleteLaptopTest() {
		Long id = 1L;
		assertEquals("deleted",lapService.deleteLaptop(id));
	}

	// Mobile

	{
		mDto.setBattery("5600maph");
		mDto.setBrand("redmi");
		mDto.setColor("blue");
		mDto.setModel("POCO X3");
		mDto.setProcessor("snap dragon");
		mDto.setRam("4GB");
	}
	{
		mDto.getBattery();
		mDto.getBrand();
		mDto.getColor();
		mDto.getModel();
		mDto.getProcessor();
		mDto.getRam();
	}
	{
		m.setProductId(1L);
		m.setBattery("4r53");
		m.setBrand("poco");
		m.setColor("lue");
		m.setModel("redmi");
		m.setProcessor("android");
		m.setRam("4");
		m.getProductId();
	}
	{
		m.getBattery();
		m.getBrand();
		m.getColor();
		m.getModel();
		m.getProcessor();
		m.getProductId();
		m.getRam();
		}

	@Order(8)

	@Test
	void saveMobileTest() {
		assertEquals("Product saved successfully", mobileService.saveMobile(mDto));
	}

	@Order(9)

	@Test
	void getAllMobilesTest() {
		assertEquals(1, mobileService.getAllMobiles().size());
	}

	@Order(10)

	@Test
	void getMobileByIdTest() {
		Long id = 1L;
		assertEquals(id, mobileService.getMobileById(id).getProductId());
	}

	@Order(11)

	@Test
	void getMobileByIdFail() {

		Long id = 20L;
		assertThrows(ResourceNotFoundException.class, () -> mobileService.getMobileById(id),
				"user not found with userId : " + id + "");

	}

	@Order(12)

	@Test
	void updateMobileByIdTest() {
		Long id = 1L;
		assertEquals("Product Updated Successfully", mobileService.updateMobile(mDto, id));
	}

	@Order(13)

	@Test
	void updateMobileByIdFail() {
		Long id = 20L;
		assertThrows(ResourceNotFoundException.class, () -> mobileService.updateMobile(mDto, id),
				"user not found with userId : " + id + "");
	}

	@Order(14)

	@Test
	void deleteMobileTest() {
		Long id = 1L;
		assertEquals("deleted",mobileService.deleteMobile(id));
	} // TV

	{
		tvDto.setBrand("LG");
		tvDto.setColor("black");
		tvDto.setModel("ghy");
		tvDto.setSmartTv("no");
	}
	{
		tv.setProductId(1L);
		tv.setBrand("samsung");
		tv.setColor("red");
		tv.setModel("mi 45r");
		tv.setSmartTv("yes");
		tv.getProductId();
	}
	{
		tvDto.getBrand();
		tvDto.getColor();
		tvDto.getModel();
		tvDto.getSmartTv();
	}
	{
		tv.getBrand();
		tv.getColor();
		tv.getModel();
		tv.getProductId();
		tv.getSmartTv();
	}

	@Order(15)

	@Test
	void saveTvTest() {
		assertEquals("Product saved successfully", tvService.saveTv(tvDto));
	}

	@Order(16)

	@Test
	void getAllTvsTest() {
		assertEquals(1, tvService.getAllTvs().size());
	}

	@Order(17)

	@Test
	void getTvByIdTestPass() {
		Long id = 1L;
		assertEquals(id, tvService.getTvById(id).getProductId());
	}

	@Order(18)

	@Test
	void getTvByIdTestFail() {

		Long id = 12L;
		assertThrows(ResourceNotFoundException.class, () -> tvService.getTvById(id),
				"user not found with userId : " + id + "");

	}

	@Order(19)

	@Test
	void updateTvByIdPass() {
		Long id = 1L;
		assertEquals("Product Updated Successfully", tvService.updateTv(tvDto, id));
	}

	@Order(20)

	@Test
	void updateTvByIdFail() {
		Long id = 20L;
		assertThrows(ResourceNotFoundException.class, () -> tvService.updateTv(tvDto, id),
				"user not found with userId : " + id + "");
	}

	@Order(21)

	@Test
	void deleteTvTest() {
		Long id = 1L;
		assertEquals("deleted",tvService.deleteTv(id));
	}

	// watches

	{

		wDto.setBrand("jdj");
		wDto.setColor("blue");
		wDto.setConnectorType("blue tooth");
		wDto.setModel("wygdd");
		wDto.setStyle("band");
		wDto.setWaterRessistent(false);
	}
	{
		wDto.getBrand();
		wDto.getColor();
		wDto.getConnectorType();
		wDto.getModel();
		wDto.getStyle();
	}
	{
		w.setProductId(1L);
		w.setBrand("csk");
		w.setColor("blue");
		w.setConnectorType("bluetooth");
		w.setModel("band");
		w.setStyle("bghs");
		w.setWaterRessistent(false);
	
	}
	{
		w.getBrand();
		w.getColor();
		w.getConnectorType();
		w.getModel();
		w.getProductId();
		w.getStyle();
	}

	@Order(22)

	@Test
	void saveWatchesTest() {
		assertEquals("Product saved successfully", watchService.saveWatches(wDto));
	}

	@Order(23)

	@Test
	void getAllWatchesTest() {

		assertEquals(1, watchService.getAllWatches().size());
	}

	@Order(24)

	@Test
	void getWatchByIdTest() {
		Long id = 1L;
		assertEquals(id, watchService.getWatchesById(id).getProductId());
	}

	@Order(25)

	@Test
	void getWatchByIdTestFail() {

		Long id = 20L;
		assertThrows(ResourceNotFoundException.class, () -> watchService.getWatchesById(id),
				"user not found with userId : " + id + "");

	}

	@Order(26)

	@Test
	void updateWatchesByIdFail() {
		Long id = 19L;
		assertThrows(ResourceNotFoundException.class, () -> watchService.updateWatches(wDto, id),
				"user not found with userId : " + id + "");
	}

	@Order(27)

	@Test
	void updateWatchByIdPass() {
		Long id = 1L;
		assertEquals("Product Updated Successfully", watchService.updateWatches(wDto, id));
	}

	@Order(28)

	@Test
	void deleteWatchTest() {
		Long id = 1L;
		assertEquals("deleted",watchService.deleteWatches(id));
	}

	
	@Order(29)
	@Test
	void saveLaptopTestC() {
		assertEquals(HttpStatus.OK, productController.saveLaptop(lapDto).getStatusCode());
	}

	@Order(30)
	@Test
	void getAllLaptopsTestC() {
		assertEquals(1, productController.getAllLaptop().size());
	}

	@Order(31)
	@Test
	void getLaptopByIdTestC() {
		Long id = 2L;
		assertEquals(HttpStatus.OK, productController.getLaptopById(id).getStatusCode());
	}

	@Order(32)
	@Test
	void updateLaptopTestC() {
		Long id = 2L;
		assertEquals(update, productController.updateLaptop(lapDto, id).getBody());
	}
	@Order(33)
	@Test
	void deleteLaptopTestC() {
		Long id = 2L;
		assertEquals(del, productController.deleteLaptop(id).getBody());
	}
	
	@Order(34)
	@Test
	void saveWatchesTestC() {
		assertEquals(HttpStatus.OK, productController.saveWatches(wDto).getStatusCode());
	}

	@Order(35)
	@Test
	void getAllWatchesTestC() {
		assertEquals(1, productController.getAllWatches().size());
	}

	@Order(36)
	@Test
	void getWatchByIdTestC() {
		Long id = 2L;
		assertEquals(HttpStatus.OK, productController.getWatchesById(id).getStatusCode());
	}

	@Order(37)
	@Test
	void updateWatchesTestC() {
		Long id = 2L;
		assertEquals(update, productController.updateWatches(wDto, id).getBody());
		}
	
	@Order(38)
	@Test
	void deleteWatchesTestC() {
		Long id = 2L;
		assertEquals(del, productController.deleteWatch(id).getBody());
	}

	@Order(39)
	@Test
	void saveMobileTestC() {
		assertEquals(HttpStatus.OK, productController.saveMobile(mDto).getStatusCode());
	}

	@Order(40)
	@Test
	void getAllMobilesTestC() {
		assertEquals(1, productController.getAllMobile().size());

	}

	@Order(41)
	@Test
	void getMobileByIdTestC() {
		Long id = 2L;
		assertEquals(HttpStatus.OK, productController.getMobileById(id).getStatusCode());
	}
	@Order(42)
	@Test
	void updateMobileTestC() {
		Long id = 2L;
		assertEquals(update, productController.updateMobile(mDto, id).getBody());

	}

	@Order(43)
	@Test
	void deleteMobileTestC() {
		Long id = 2L;
		assertEquals(del, productController.deleteMobile(id).getBody());
	}

	@Order(44)
	@Test
	void saveTvTestC() {
		assertEquals(HttpStatus.OK, productController.saveTv(tvDto).getStatusCode());
	}

	@Order(45)
	@Test
	void getAllTvsTestC() {
		assertEquals(1, productController.getTv().size());
	}

	@Order(46)
	@Test
	void getTvByIdTestC() {
		Long id=2L;
		assertEquals(HttpStatus.OK, productController.getTvById(id).getStatusCode());
	}
	@Order(47)
	@Test
	void updateTvTest() {
		Long id = 2L;
		assertEquals(update, productController.updateTv(tvDto, id).getBody());

	}
	
	@Order(48)
	@Test
	void deleteTvTestC() {
		Long id = 2L;
		assertEquals(del, productController.deleteTv(id).getBody());
	}
}
