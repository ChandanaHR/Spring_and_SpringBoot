//Constructor-based injection
//Patient.java
//A simple class with a method getPatientDetails(), marked with @Component so Spring knows to manage (instantiate) it.
@Component
public class Patient {
    public void getPatientDetails() {
        System.out.println("Fetching patient details from DB...");
    }
}
//When Spring starts, it sees @Component and creates a singleton bean for PatientRepository.

//Doctor.java
//A class that needs PatientRepository to perform its job. It does not create the PatientRepository — instead, Spring gives it.
@Component //This tells Spring:👉 "Please create an object of Doctor and manage it in the Spring container as a bean."
public class Doctor {
    private final Patient patientRepository; //A field to store the dependency (Patient).

    @Autowired                                            //Spring sees that the Doctor needs a Patient object to be passed into its constructor.

                                                          //Spring automatically injects an instance of Patient (which is also marked with @Component) into this constructor.

                                                             //The passed-in object is stored in the private field.
    public Doctor(Patient patientRepository) {
        this.patientRepository = patientRepository;
    }
    //Business method
    public void treatPatient() {
        patientRepository.getPatientDetails();   //This method uses the injected dependency (patientRepository) to call a method.
        System.out.println("Doctor is treating the patient.");
    }
}

//Spring sees DoctorService is a component.
//It notices the constructor has a PatientRepository parameter.
//It checks: Do I already have a bean of type PatientRepository? Yes.
//It creates an instance of DoctorService, injects the PatientRepository, and keeps the bean ready.
//When you ask Spring for a DoctorService, it gives you a fully-wired object, ready to use.

//Setterbases injection
//Patient.java
import org.springframework.stereotype.Component;

@Component
public class Patient {
    public void getPatientDetails() {
        System.out.println("Fetching patient details from DB...");
    }
}
//This class is marked with @Component.
//So Spring creates an object of PatientRepository and manages it in the IoC container.
//Now it's ready to be injected into any other bean that needs it.

//Doctor.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Doctor {
    private Patient patientRepository;

    // Setter method with @Autowired
    @Autowired
    public void setPatientRepository(Patient patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void treatPatient() {
        patientRepository.getPatientDetails();
        System.out.println("Doctor is treating the patient.");
    }
}
//Spring looks for ways to inject its dependencies. It finds this method:
//Spring says:
//“Oh! This is a setter method expecting a PatientRepository. I already have one. I’ll inject it!”
//So Spring calls the setter method and passes in the existing PatientRepository object.

//Main.java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HospitalApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(HospitalApplication.class, args);

        Doctor doctorService = context.getBean(DoctorService.class);
        doctorService.treatPatient();
    }
}





