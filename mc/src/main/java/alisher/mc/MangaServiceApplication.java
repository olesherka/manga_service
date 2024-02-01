package alisher.mc;


import alisher.mc.service.MangaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
public class MangaServiceApplication {

	public static void main(String[] args) throws InterruptedException{
		SpringApplication.run(MangaServiceApplication.class, args);
		/*ConfigurableApplicationContext ctx =SpringApplication.run(MangaServiceApplication.class, args);
		MangaService mangaService = ctx.getBean("mangaService", MangaService.class);
		log.info("Mangas - {}", mangaService.getAllMangas());*/
	}


}
