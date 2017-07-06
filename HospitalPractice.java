import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;


import java.util.Scanner;
import java.util.TreeSet;


class Hospital implements Comparable<Hospital> {
    String hospitalName;
    Doctor doc;
    Address hospitalAddress;
    
    public Hospital(String hospitalName, Doctor doc, Address hospitalAddress){
    	this.hospitalName = hospitalName;
    	this.doc = doc;
    	this.hospitalAddress = hospitalAddress;
    }

	@Override
	public String toString() {
		return "Hospital [hospitalName=" + hospitalName + ", doc=" + doc + ", hospitalAddress=" + hospitalAddress + "]";
	}

	@Override
	public int compareTo(Hospital o) {
		// TODO Auto-generated method stub
		int result = hospitalName.compareTo(o.hospitalName);
		
		if(result==0){
			int result1 = hospitalAddress.compareTo(o.hospitalAddress);
			if(result1==0){
				return 0;
			}
			else{
				return 1;
			}
		}
		else{
			return 1;
		}
	
	}
	
}

class Doctor implements Comparable<Doctor>{
   int docId;
   String name;
   String specialization;
   
   @Override
public String toString() {
	return "Doctor [docId=" + docId + ", name=" + name + ", specialization=" + specialization + "]";
}

public Doctor(int docId, String name, String specialization){
	   this.docId = docId;
	   this.name = name;
	   this.specialization = specialization; 
   }

@Override
public int compareTo(Doctor o) {
	// TODO Auto-generated method stub
	return 0;
}
   
}

class Address implements Comparable<Address>{
   String address1;
   String address2;
   String city;
   
   @Override
public String toString() {
	return "Address [address1=" + address1 + ", address2=" + address2 + ", city=" + city + ", state=" + state
			+ ", zipCode=" + zipCode + "]";
}

String state;
   int zipCode;
   
   public Address(String address1, String address2, String city, String state, int zipCode){
	   this.address1 = address1;
	   this.address2 = address2;
	   this.city = city;
	   this.state = state;
	   this.zipCode = zipCode;
   }

@Override
public int compareTo(Address o) {
	int result = address1.compareTo(o.address1);
	
	if(result==0){
		int result1 = address2.compareTo(o.address2);
		int result2= city.compareTo(o.city);
		int result3=state.compareTo(o.state);
		
		if(result1==0 && result2==0 && result3==0 && (zipCode==o.zipCode)){
			return 0;
		}
		else{
			return 1;
		}
	}else{
		return 1;
	}
	
 }
}

public class HospitalPractice{
	public static void main(String args[]) throws IOException{
		Scanner scan = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Address add1 = new Address("22505", "Landmark Ct", "Ashburn", "Virginia", 20148);
		Address add2 = new Address("24440", "Stone Springs Blvd", "Dulles", "Virginia", 20166); 
		Address add3 = new Address("44045", "Riverside Pkwy", "Leesburg", "Virginia", 20176);   
		
		Doctor doc1 = new Doctor(12435,"Steve Butler", "Dentist");
		Doctor doc2 = new Doctor(27645,"Mark Benson", "Skin");
		Doctor doc3 = new Doctor(18429,"Jolie Robinson", "Dentist");
		Doctor doc4 = new Doctor(46453,"Sunil Patel", "General");
		Doctor doc5 = new Doctor(63245,"Smriti Aggarwal", "Skin");
		Doctor doc6 = new Doctor(17232,"Lindsey Robbert", "General");
		Doctor doc7 = new Doctor(96633,"Neeta Goel", "Child Specialist");
		Doctor doc8 = new Doctor(43245,"Sundeep Singh", "Child Specialist");
		Doctor doc9 = new Doctor(56735,"Sheena Malik", "General");
		
		Hospital h1 = new Hospital("Specialists of Virginia", doc1, add1);
		Hospital h2 = new Hospital("Specialists of Virginia", doc9, add1);
		Hospital h3 = new Hospital("Specialists of Virginia", doc8, add1);
		Hospital h4 = new Hospital("StoneSprings Hospital", doc3, add2);
		Hospital h5 = new Hospital("StoneSprings Hospital", doc4, add2);
		Hospital h6 = new Hospital("StoneSprings Hospital", doc5, add2);
		Hospital h7 = new Hospital("Inova Loudoun Hospital", doc6, add3);
		Hospital h8 = new Hospital("Inova Loudoun Hospital", doc7, add3);
		Hospital h9 = new Hospital("Inova Loudoun Hospital", doc2, add3);
		
		TreeSet<Hospital> hospital = new TreeSet<Hospital>();
		hospital.add(h1);
		hospital.add(h2);
		hospital.add(h3);
		hospital.add(h4);
		hospital.add(h5);
		hospital.add(h6);
		hospital.add(h7);
		hospital.add(h8);
		hospital.add(h9);

		Iterator<Hospital> itr = hospital.iterator();
		System.out.println("1.) Unique Hospitals are listed below: ");
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		System.out.println();
		System.out.println("2.) Enter your location zipcode to find the nearest hospital: ");
		long zip=scan.nextLong();
		
		int len = String.valueOf(zip).length();
		if(len>5){
			System.out.println("Invalid Zipcode!!");
			System.exit(0);
		}
	    	
		HashSet<Hospital> hos = new HashSet<Hospital>();
		hos.add(h1);
		hos.add(h2);
		hos.add(h3);
		hos.add(h4);
		hos.add(h5);
		hos.add(h6);
		hos.add(h7);
		hos.add(h8);
		hos.add(h9);
		
		int count=0;
		long savezip=0;
		long zipdiff=0, prevdiff=0;
		int flag=0;
		Hospital near = null;
		Iterator<Hospital> itr1 = hos.iterator();
		while(itr1.hasNext()){
			Hospital h = itr1.next();	
			flag=0;
			if(count==0){
			flag=1;
			savezip = h.hospitalAddress.zipCode;
			near=h;
			prevdiff = Math.abs(h.hospitalAddress.zipCode - zip);
			 count++;
			}
			
			if(count>0 && flag==0){
				zipdiff = Math.abs(h.hospitalAddress.zipCode - zip);
				if(zipdiff<prevdiff){
					savezip = h.hospitalAddress.zipCode;
					prevdiff = zipdiff;
					near=h;
				}
				count++;
			}
			
		}
		System.out.println("Nearest hospital to your zipcode is "+near.hospitalName);
		System.out.println("Address of the hospital is "+near.hospitalAddress.address1+" "+near.hospitalAddress.address2+" "+near.hospitalAddress.city+" "+near.hospitalAddress.state+"-"+near.hospitalAddress.zipCode);
	     
		System.out.println();System.out.println();
	 
		System.out.println("3.) For better result, select one of the available option (Dentist, Skin, General, Child Specialist) to find the nearest hospital with the available doctor name: ");
		String illness = br.readLine();
	    int countill=0, flg=0;
	    long prev=0, next=0;
	    Hospital near_ill = null;
		Iterator<Hospital> itr2 = hos.iterator();
		while(itr2.hasNext()){
			Hospital h = itr2.next();
			flg=0;
			//System.out.println(illness.compareTo(h.doc.specialization));
			//System.out.println(illness+" "+h.doc.specialization);
			int compare = illness.compareTo(h.doc.specialization);
			if(compare==0){
				if(countill==0){
					prev = Math.abs(h.hospitalAddress.zipCode - zip);
					savezip = h.hospitalAddress.zipCode;
					//System.out.println(savezip+" "+countill);
					near_ill = h;
					flg=1;
					countill++;
				}
				if(countill>0 && flg==0){
					next = Math.abs(h.hospitalAddress.zipCode - zip);
					if(next<prev){
						savezip = h.hospitalAddress.zipCode;
						near_ill = h;
						//System.out.println(savezip+" "+countill);
					}
					countill++;
				}
			}
		}
		System.out.println();System.out.println();
		System.out.println("Hospital near to your place with the specialist you're looking for is--> "+near_ill.hospitalName);
		System.out.println("Address of the hospital is--> "+near_ill.hospitalAddress.address1+" "+near_ill.hospitalAddress.address2+" "+near_ill.hospitalAddress.city+" "+near_ill.hospitalAddress.state+"-"+near_ill.hospitalAddress.zipCode);
	    System.out.println("Doctor's name is--> "+near_ill.doc.name+" and their specialization is "+near_ill.doc.specialization);
	
	    System.out.println();System.out.println();
	    

	    HashMap<String,ArrayList<Doctor>> hosp = new HashMap<String,ArrayList<Doctor>>();
	    ArrayList<Doctor> docinfo1 = new ArrayList<Doctor>();
	    docinfo1.add(doc1);
	    docinfo1.add(doc9);
	    docinfo1.add(doc8);
	    ArrayList<Doctor> docinfo2 = new ArrayList<Doctor>();
	    docinfo2.add(doc3);
	    docinfo2.add(doc4);
	    docinfo2.add(doc5);
	    ArrayList<Doctor> docinfo3 = new ArrayList<Doctor>();
	    docinfo3.add(doc6);
	    docinfo3.add(doc7);
	    docinfo3.add(doc2);
	    
	    hosp.put("Specialists of Virginia", docinfo1);
	    hosp.put("StoneSprings Hospital", docinfo2);
	    hosp.put("Inova Loudoun Hospital", docinfo3);
	    
	  
	    System.out.println("4.) Enter the hospital name [Specialists of Virginia, StoneSprings Hospital, Inova Loudoun Hospital] to list out all the doctors working in that hospital: ");
	    String hosp_Name = br.readLine();
	    System.out.println("Doctors information in this hospital is as follows: ");
	    for(Entry<String, ArrayList<Doctor>> parse: hosp.entrySet()){
	    	String getString = parse.getKey();
	    	int val = hosp_Name.compareTo(getString);
	    	if(val==0){
	    		ArrayList<Doctor> d = parse.getValue();
	    		Iterator<Doctor> itd = d.iterator();
	    		while(itd.hasNext()){
	    			Doctor detail = itd.next();
	    			System.out.println("Dr. "+detail.name+" and Specialization: "+detail.specialization);
	    		}
	    		
	    	}
	    }
	    
	   
	    System.out.println("5.) Enter the specialization to list out all the doctors with that specialization and their hospital information: ");
	    String special = br.readLine();
	    String hospital1 = null;
	    for(Entry<String, ArrayList<Doctor>> parse1: hosp.entrySet()){
	    	ArrayList<Doctor> d = parse1.getValue();
	    	Iterator<Doctor> itd = d.iterator();
	    	hospital1 = parse1.getKey();
	    	while(itd.hasNext()){
	    		Doctor d1 = itd.next();
	    		int result = special.compareTo(d1.specialization);
	    		if(result==0){
	    		  System.out.println();
	    		  System.out.println("Hospital name: "+hospital1);	
	    		  Iterator<Hospital> itr3 = hospital.iterator();
	    		  while(itr3.hasNext()){
	    			  Hospital hosp2 = itr3.next();
	    			  int result2 = hospital1.compareTo(hosp2.hospitalName);
	    			  if(result2==0){
	    				  System.out.println("Hospital Address: ");
	    				  System.out.println(hosp2.hospitalAddress.address1+" "+hosp2.hospitalAddress.address2+" "+hosp2.hospitalAddress.city+" "+hosp2.hospitalAddress.state+"-"+hosp2.hospitalAddress.zipCode);

	    			  }
	    		  }
	    		  
	    		  System.out.println("Dr. "+d1.name+" Specialization--> "+d1.specialization);	
	    		}
	    	}
	    	
	    }
	    
	}
	
}


/*
1.) Unique Hospitals are listed below: 
Hospital [hospitalName=Specialists of Virginia, doc=Doctor [docId=12435, name=Steve Butler, specialization=Dentist], hospitalAddress=Address [address1=22505, address2=Landmark Ct, city=Ashburn, state=Virginia, zipCode=20148]]
Hospital [hospitalName=StoneSprings Hospital, doc=Doctor [docId=18429, name=Jolie Robinson, specialization=Dentist], hospitalAddress=Address [address1=24440, address2=Stone Springs Blvd, city=Dulles, state=Virginia, zipCode=20166]]
Hospital [hospitalName=Inova Loudoun Hospital, doc=Doctor [docId=17232, name=Lindsey Robbert, specialization=General], hospitalAddress=Address [address1=44045, address2=Riverside Pkwy, city=Leesburg, state=Virginia, zipCode=20176]]

2.) Enter your location zipcode to find the nearest hospital: 
23324
Nearest hospital to your zipcode is Inova Loudoun Hospital
Address of the hospital is 44045 Riverside Pkwy Leesburg Virginia-20176


3.) For better result, select one of the available option (Dentist, Skin, General, Child Specialist) to find the nearest hospital with the available doctor name: 
Skin


Hospital near to your place with the specialist you're looking for is--> Inova Loudoun Hospital
Address of the hospital is--> 44045 Riverside Pkwy Leesburg Virginia-20176
Doctor's name is--> Mark Benson and their specialization is Skin


4.) Enter the hospital name [Specialists of Virginia, StoneSprings Hospital, Inova Loudoun Hospital] to list out all the doctors working in that hospital: 
Inova Loudoun Hospital
Doctors information in this hospital is as follows: 
Dr. Lindsey Robbert and Specialization: General
Dr. Neeta Goel and Specialization: Child Specialist
Dr. Mark Benson and Specialization: Skin
5.) Enter the specialization to list out all the doctors with that specialization and their hospital information: 
Skin

Hospital name: Inova Loudoun Hospital
Hospital Address: 
44045 Riverside Pkwy Leesburg Virginia-20176
Dr. Mark Benson Specialization--> Skin

Hospital name: StoneSprings Hospital
Hospital Address: 
24440 Stone Springs Blvd Dulles Virginia-20166
Dr. Smriti Aggarwal Specialization--> Skin

*/