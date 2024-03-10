package jpademo;

import jpademo.entities.Patient;
import jpademo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JpademoApp implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(JpademoApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        patientRepository.save(new Patient(null, "ziad", new Date(), false, 9999));
        patientRepository.save(new Patient(null, "abdel", new Date(), true, -9999));
        patientRepository.save(new Patient(null, "EL", new Date(), false, 87));
        patientRepository.save(new Patient(null, "Hakim", new Date(), true, 435));

        List<Patient> patients = patientRepository.findAll();
        for(Patient p: patients){
            System.out.println(p);
        }
    }
}
