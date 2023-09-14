package com.uir.smartAgri;

import com.uir.smartAgri.Entities.Farm;
import com.uir.smartAgri.Entities.User;
import com.uir.smartAgri.Services.FarmService;
import com.uir.smartAgri.Services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;
import java.util.stream.Stream;


@SpringBootApplication(scanBasePackages = {"com.uir.smartAgri"})

public class SmartAgriApplication implements CommandLineRunner {
	@Autowired
	FarmService farmService;
	@Autowired
	UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(SmartAgriApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Stream.of("Farms1","Farms2","Farms3","Farms4","Farms5","Farms6","Farms7","Farms8").forEach(farms->{
			Farm f = new Farm();
			f.setName(farms);
			f.setAddress(farms+"   Adress" );
			f.setArea((float) (Math.random()*19));
			f.setLongitude((float) (Math.random()*19));
			f.setLatitude((float) (Math.random()*19));
			f.setDescription("Description of "+farms);
			farmService.save(f);
		});
		Stream.of("User1","User2","User3","User4","User5","User6","User7","User8").forEach(users->{
			User user = new User();
			user.setUsername(users);
			user.setPhone(users+" Phone");
			user.setEmail(users+"@gmail.com");
			user.setPassword("password");
			user.setName(users + "ait bou");
			userService.add_user(user);
		});
		List<Farm> Allfarm =farmService.findAll();
		List<User> list_user=userService.list_user();
		for(Farm farm : Allfarm){
			for(User user : list_user){
				double rand = Math.random();
				if(rand>0.4){
					farmService.addUserToFarm(user.getUsername(), farm.getName());
				}

			}

		}
		Farm f = new Farm();
		f.setName("exemple");
		f.setAddress("exemple   Adress");
		f.setArea((float) (Math.random()*19));
		f.setLongitude((float) (Math.random()*19));
		f.setLatitude((float) (Math.random()*19));
		f.setDescription("exemple of Deescription");
		farmService.save(f);
	}
}
