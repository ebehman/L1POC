/*
 * package com.ecommerce;
 * 
 * import static org.junit.jupiter.api.Assertions.assertEquals; import static
 * org.junit.jupiter.api.Assertions.assertThrows; import static
 * org.mockito.Mockito.times; import static org.mockito.Mockito.verify; import
 * static org.mockito.Mockito.when;
 * 
 * import java.util.ArrayList; import java.util.Optional; import
 * java.util.stream.Collectors; import java.util.stream.Stream;
 * 
 * import org.junit.jupiter.api.Test; import org.junit.runner.RunWith; import
 * org.mockito.InjectMocks; import org.mockito.Mock; import
 * org.springframework.beans.BeanUtils; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.test.context.junit4.SpringRunner;
 * 
 * import com.ecommerce.exception.ResourceNotFoundException; import
 * com.ecommerce.model.Laptop; import com.ecommerce.model.Mobile; import
 * com.ecommerce.model.Tv; import com.ecommerce.model.Watches; import
 * com.ecommerce.products.dto.LaptopDto; import
 * com.ecommerce.products.dto.MobileDto; import
 * com.ecommerce.products.dto.TvDto; import
 * com.ecommerce.products.dto.WatchesDto; import
 * com.ecommerce.repository.LaptopRepository; import
 * com.ecommerce.repository.MobileRepository; import
 * com.ecommerce.repository.TvRepository; import
 * com.ecommerce.repository.WatchesRepository; import
 * com.ecommerce.service.LaptopService; import
 * com.ecommerce.service.MobileService; import com.ecommerce.service.TvService;
 * import com.ecommerce.service.WatchesService;
 * 
 * @RunWith(SpringRunner.class)
 * 
 * @SpringBootTest class ProductServiceTest {
 * 
 * @Mock private LaptopRepository lapRepo;
 * 
 * @Mock private MobileRepository mobileRepo;
 * 
 * @Mock private TvRepository tvRepo;
 * 
 * @Mock private WatchesRepository watchRepo;
 * 
 * @InjectMocks private LaptopService lapService;
 * 
 * @InjectMocks private MobileService mobileService;
 * 
 * @InjectMocks private TvService tvService;
 * 
 * @InjectMocks private WatchesService watchService;
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
 * ("1kg");}
 * 
 * @Test void saveLaptopTest() { BeanUtils.copyProperties(lapDto, lap);
 * when(lapRepo.save(lap)).thenReturn(lap); assertEquals(lapDto,
 * lapService.saveLaptop(lapDto)); }
 * 
 * @Test void getAllLaptopsTest() { ArrayList<Laptop> ll = new ArrayList<>();
 * 
 * ll.add(lap);
 * 
 * when(lapRepo.findAll()).thenReturn(Stream .of(new Laptop(1L, "hp", "probook",
 * "gray", "windows", "no", "1kg"), new Laptop(2L, "Lenovo", "ideapad", "black",
 * "windows", "no", "1.5kg")) .collect(Collectors.toList())); assertEquals(2,
 * lapService.getAllLaptop().size()); }
 * 
 * @Test void getLaptopByIdTest() { Long id = 1L; Optional<Laptop> lap =
 * Optional .ofNullable(new Laptop(1L, "Lenovo", "ideapad", "black", "windows",
 * "no", "1.5kg")); when(lapRepo.findById(id)).thenReturn(lap);
 * assertEquals(lap.get(), lapService.getLaptopById(id)); }
 * 
 * @Test void getLaptopByIdFail() {
 * 
 * Long id = null; assertThrows(ResourceNotFoundException.class, () ->
 * lapService.getLaptopById(id), "user not found with userId : " + id + "");
 * 
 * }
 * 
 * @Test void deleteLaptopTest() { Long id = 1L; lapService.deleteLaptop(id);
 * verify(lapRepo, times(1)).deleteById(id); }
 * 
 * @Test void updateLaptopByIdFail() { Long id = 1L;
 * assertThrows(ResourceNotFoundException.class, () ->
 * lapService.updateLaptop(lapDto, id), "user not found with userId : " + id +
 * ""); }
 * 
 * // Mobile
 * 
 * { mDto.setBattery("5600maph"); mDto.setBrand("redmi"); mDto.setColor("blue");
 * mDto.setModel("POCO X3"); mDto.setProcessor("snap dragon");
 * mDto.setRam("4GB"); } { m.setProductId(1L); m.setBattery("4r53");
 * m.setBrand("poco"); m.setColor("lue"); m.setModel("redmi");
 * m.setProcessor("android"); m.setRam("4"); m.getProductId(); }
 * 
 * @Test void saveMobileTest() { Mobile m = new Mobile();
 * BeanUtils.copyProperties(mDto, m); when(mobileRepo.save(m)).thenReturn(m);
 * assertEquals(mDto, mobileService.saveMobile(mDto)); }
 * 
 * @Test void getAllMobilesTest() {
 * 
 * when(mobileRepo.findAll()).thenReturn(Stream .of(new Mobile(1L, "redmi",
 * "POCO X3", "blue", "4gb", "snapdragon", "5600maph"), new Mobile(2L, "vivo",
 * "vivo Z1 PRO", "gray", "4gb", "snapdragon", "5100maph"))
 * .collect(Collectors.toList())); assertEquals(2,
 * mobileService.getAllMobiles().size()); }
 * 
 * @Test void getMobileByIdTest() { Long id = 1L; Optional<Mobile> m = Optional
 * .ofNullable(new Mobile(2L, "vivo", "vivo Z1 PRO", "gray", "4gb",
 * "snapdragon", "5100maph")); when(mobileRepo.findById(id)).thenReturn(m);
 * assertEquals(m.get(), mobileService.getMobileById(id)); }
 * 
 * @Test void getMobileByIdFail() {
 * 
 * Long id = null; assertThrows(ResourceNotFoundException.class, () ->
 * mobileService.getMobileById(id), "user not found with userId : " + id + "");
 * 
 * }
 * 
 * @Test void deleteMobileTest() { Long id = 1L; mobileService.deleteMobile(id);
 * verify(mobileRepo, times(1)).deleteById(id); }
 * 
 * @Test void updateMobileByIdFail() { Long id = 1L;
 * assertThrows(ResourceNotFoundException.class, () ->
 * mobileService.updateMobile(mDto, id), "user not found with userId : " + id +
 * ""); }
 * 
 * // TV
 * 
 * { tvDto.setBrand("LG"); tvDto.setColor("black"); tvDto.setModel("ghy");
 * tvDto.setSmartTv("no"); } { tv.setProductId(1L); tv.setBrand("samsung");
 * tv.setColor("red"); tv.setModel("mi 45r"); tv.setSmartTv("yes");
 * tv.getProductId(); }
 * 
 * @Test void saveTvTest() { Tv tv = new Tv(); BeanUtils.copyProperties(tvDto,
 * tv); when(tvRepo.save(tv)).thenReturn(tv); assertEquals(tvDto,
 * tvService.saveTv(tvDto)); }
 * 
 * @Test void getAllTvsTest() {
 * 
 * when(tvRepo.findAll()).thenReturn( Stream.of(new Tv(1L, "LG", "LG 5RE",
 * "gray", "yes"), new Tv(1L, "LG", "LG 5RE", "gray", "yes"))
 * .collect(Collectors.toList())); assertEquals(2,
 * tvService.getAllTvs().size()); }
 * 
 * @Test void getTvByIdTestPass() { Long id = 1L; Optional<Tv> tv =
 * Optional.ofNullable(new Tv(1L, "LG", "LG 5RE", "gray", "yes"));
 * when(tvRepo.findById(id)).thenReturn(tv); assertEquals(tv.get(),
 * tvService.getTvById(id)); }
 * 
 * @Test void getTvByIdTestFail() {
 * 
 * Long id = null; assertThrows(ResourceNotFoundException.class, () ->
 * tvService.getTvById(id), "user not found with userId : " + id + "");
 * 
 * }
 * 
 * @Test void deleteTvTest() { Long id = 1L; tvService.deleteTv(id);
 * verify(tvRepo, times(1)).deleteById(id); }
 * 
 * @Test void updateTvByIdFail() { Long id = 1L;
 * assertThrows(ResourceNotFoundException.class, () -> tvService.updateTv(tvDto,
 * id), "user not found with userId : " + id + ""); }
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
 * @Test void saveWatchesTest() { Watches w = new Watches();
 * BeanUtils.copyProperties(wDto, w); when(watchRepo.save(w)).thenReturn(w);
 * assertEquals(wDto, watchService.saveWatches(wDto)); }
 * 
 * @Test void getAllWatchesTest() { when(watchRepo.findAll()).thenReturn(Stream
 * .of(new Watches(1L, "hilfiger", "HIF 65d", "gold ", "SDFR5", "bluetooth",
 * true), new Watches(2L, "mi", "band", "black ", "Sband", "bluetooth", true))
 * .collect(Collectors.toList())); assertEquals(2,
 * watchService.getAllWatches().size()); }
 * 
 * @Test void getWatchByIdTest() { Long id = 1L; Optional<Watches> w = Optional
 * .ofNullable(new Watches(1L, "hilfiger", "HIF 65d", "gold ", "SDFR5",
 * "bluetooth", true)); when(watchRepo.findById(id)).thenReturn(w);
 * assertEquals(w.get(), watchService.getWatchesById(id)); }
 * 
 * @Test void getWatchByIdTestFail() {
 * 
 * Long id = null; assertThrows(ResourceNotFoundException.class, () ->
 * watchService.getWatchesById(id), "user not found with userId : " + id + "");
 * 
 * }
 * 
 * @Test void deleteWatchTest() { Long id = 1L; watchService.deleteWatches(id);
 * verify(watchRepo, times(1)).deleteById(id); }
 * 
 * @Test void updateWatchesByIdFail() { Long id = 1L;
 * assertThrows(ResourceNotFoundException.class, () ->
 * watchService.updateWatches(wDto, id), "user not found with userId : " + id +
 * ""); }
 * 
 * }
 */