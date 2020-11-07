import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class HospitalRoom {
    ReentrantLock doctorEntrylock = new ReentrantLock();
    ReentrantLock patientEntrylock = new ReentrantLock();

    AtomicInteger doctorCount = new AtomicInteger(0);
    AtomicInteger patientCount = new AtomicInteger(0);

    public boolean doctorEnter(Doctor d) throws InterruptedException {
        if(doctorCount.get() > 0 || doctorEntrylock.isLocked()) {
            System.out.println("Doctor " + d.name + " is waiting to Enter, number of doctor " + doctorCount);
        }

        while(doctorCount.get() > 0 || doctorEntrylock.isLocked()) {}

        doctorEntrylock.lock();
        System.out.println(String.format("Doctor %s Entered, number of doctor %d", d.name, doctorCount.get() + 1));
        doctorCount.incrementAndGet();
        doctorEntrylock.unlock();

        return true;
    }

    public boolean doctorLeave(Doctor d) throws InterruptedException {
        if(doctorEntrylock.isLocked()) {
            throw new IllegalStateException("Unexpected status of the system");
        }

        doctorEntrylock.lock();
        System.out.println("Doctor " + d.name + " left, number of doctor " + doctorCount.decrementAndGet());
        doctorEntrylock.unlock();

        return true;
    }

    public boolean patientEnter(Patient p) throws InterruptedException {
        if(patientCount.get() > 2 || patientEntrylock.isLocked()) {
            System.out.println("Patient " + p.name + " is waiting to Enter, number of patient " + patientCount);
        }

        while(patientCount.get() > 2 || patientEntrylock.isLocked()) {}

        patientEntrylock.lock();
        System.out.println(String.format("Patient %s Entered, number of patient %d", p.name, patientCount.get() + 1));
        patientCount.incrementAndGet();
        patientEntrylock.unlock();

        return true;
    }

    public boolean patientLeave(Patient p) throws InterruptedException {
        if(patientEntrylock.isLocked()) {
            return false;
        }

        patientEntrylock.lock();
        System.out.println("Patient " + p.name + " left, number of patient " + patientCount.decrementAndGet());
        patientEntrylock.unlock();

        return true;
    }

}


class Doctor {
    public String name;
    public Doctor(String name) {
        this.name = name;
    }
}

class Patient {
    public String name;
    public Patient(String name) {
        this.name = name;
    }
}

class Main2 {
    public static void main(String[] args) {
        HospitalRoom room = new HospitalRoom();
        Doctor siva = new Doctor("siva");
        Doctor john = new Doctor("john");
        Patient p1 = new Patient("p1");
        Patient p2 = new Patient("p2");
        Patient p3= new Patient("p3");
        Patient p4 = new Patient("p4");
        Patient p5 = new Patient("p5");
        Thread doctor1 = new Thread(() -> {
            try {
                while(!room.doctorEnter(siva)) {}
                Thread.sleep(500);
                while(!room.doctorLeave(siva)) {}

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread doctor2 = new Thread(() -> {
            try {
                while(!room.doctorEnter(john)) {}
                Thread.sleep(500);
                while(!room.doctorLeave(john)) {}
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread patient1 = new Thread(() -> {
            try {
                while(!room.patientEnter(p1)) {}
                Thread.sleep(500);
                while(!room.patientLeave(p1)) {}
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread patient2 = new Thread(() -> {
            try {
                while(!room.patientEnter(p2)) {};
                Thread.sleep(500);
                while(!room.patientLeave(p2)) {};
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread patient3 = new Thread(() -> {
            try {
                while(!room.patientEnter(p3)) {};
                Thread.sleep(500);
                while(!room.patientLeave(p3)) {};
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread patient4 = new Thread(() -> {
            try {
                while(!room.patientEnter(p4)) {};
                Thread.sleep(500);
                while(!room.patientLeave(p4)) {};
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread patient5 = new Thread(() -> {
            try {
                while(!room.patientEnter(p5)) {};
                Thread.sleep(500);
                while(!room.patientLeave(p5)) {};
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        doctor1.start();
        doctor2.start();
        patient1.start();
        patient2.start();
        patient3.start();
        patient4.start();
        patient5.start();
    }
}

