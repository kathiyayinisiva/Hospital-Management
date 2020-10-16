package hospital;
import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;

class Person
{
    
    private int id;
    private String name;
    private char gender;
    
    public Person(int id,String name,char gender)
    {
        
    	this.id=id;
        this.name=name;
        this.gender=gender;
    
    }
    
    int getId()
    {
        return id;
    }
    
    String getName()
    {
        return name;
    }
    
    char getGender()
    {
        return gender;
    }
    
}

abstract class Employee extends Person
{
    
    public Employee(int id,String name,char gender)
    {
        super(id,name,gender);
    }
    
    abstract public void calSal();
    
    abstract public void paySlip();
    
}

class Doctor extends Employee
{
    
    private float bp;
    private String timing;
    private String speciality;
    private String qualif;
    float pf=0,ins=0,da=0,hra=0,gsal,netsal;
    
    
    public Doctor(int id,String name,char gender,float basic,String timing,String speciality,String qualif)
    {
        
    	super(id,name,gender);
        this.bp=basic;
        this.timing=timing;
        this.qualif=qualif;
        this.speciality=speciality;
    
    }        
    
    public float getBasic()
    {
        return bp;
    }
    
    public String getTiming()
    {
        return timing;
    }
    
    public String getSpeciality()
    {
        return speciality;
    }
    
    public String getQualif()
    {
        return qualif;
    }
    
    public void calSal()
    {
        
        if(speciality.equals("General Physician"))
        {
            
            da=(float)0.05*bp;
            hra=(float)0.05*bp;
            ins=(float)0.09*bp;
            pf=(float)0.09*bp;
        
        }
        
        else if(speciality.equals("Cardiologist"))
        {
            
        	da=(float)0.35*bp;
            hra=(float)0.35*bp;
            ins=(float)0.04*bp;
            pf=(float)0.04*bp;
        
        }
        
        else if(speciality.equals("Paediatrician"))
        {
            
        	da=(float)0.1*bp;
            hra=(float)0.1*bp;
            ins=(float)0.08*bp;
            pf=(float)0.08*bp;
        
        }
        
        else if(speciality.equals("Gynecologist"))
        {
            
        	da=(float)0.2*bp;
            hra=(float)0.2*bp;
            ins=(float)0.07*bp;
            pf=(float)0.07*bp;
        
        }
        
        else if(speciality.equals("Surgeon"))
        {
            
        	da=(float)0.4*bp;
            hra=(float)0.4*bp;
            ins=(float)0.03*bp;
            pf=(float)0.03*bp;
        
        }
        
        else if(speciality.equals("Dermatologist"))
        {
            
        	da=(float)0.3*bp;
            hra=(float)0.3*bp;
            ins=(float)0.05*bp;
            pf=(float)0.05*bp;
        
        }
        
        else if(speciality.equals("Neurologist"))
        {
            
        	da=(float)0.25*bp;
            hra=(float)0.25*bp;
            ins=(float)0.06*bp;
            pf=(float)0.06*bp;
        
        }
        
        gsal=da+hra-ins-pf;
        netsal=bp-gsal;
        
        
    }
    
    public void paySlip()
    {
        
    	System.out.println("************************************************************");
        System.out.println("ID         : "+getId());
        System.out.println("Name       : "+getName());
        System.out.println("Speciality : "+getSpeciality());
        System.out.println("Basic Pay  : "+getBasic());
        System.out.println("Insurance  : "+ins);
        System.out.println("PF         : "+pf);
        System.out.println("----------------------------");
        System.out.println("Net Salary :   "+netsal);
        System.out.println("----------------------------");
    	System.out.println("************************************************************");

    }
}


interface Drugs
{
    
	//public int checkExp();
	
	public float getTotalCost(int qty, float cost);
        public void checkStock();
	
	//public void billDisplay();

}

class Medicine implements Drugs
{
    
    private String name;
    private String seller;
    private String expdate;
    private float cost;
    private int qty;
    
    public Medicine(String name, String seller, String expdate, float cost, int qty)
    {
        
    	this.name=name;
        this.seller=seller;
        this.expdate=expdate;
        this.cost=cost;
        this.qty=qty;
    
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getSeller()
    {
        return seller;
    }
    
    public String getExpdate()
    {
        return expdate;
    }
    
    public float getCost()
    {
        return cost;
    }
    
    public int getQty()
    {
        return qty;
    }
    
        
   /* public int checkExp()
    {

    	SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");
    	Date today = sdf.parse(java.time.LocalDate.now());
    	Date exp = sdf.parse(getExpdate());
    	
    	if (today.compareTo(exp) > 0) 
    	{
    	      return -1;      
    	} 
    	else if (today.compareTo(exp) < 0) 
    	{
    	      return 1;
        } 
    	else if (today.compareTo(exp) == 0) 
    	{
    		  return 0;
    	}
    	
    } */
    
    public float getTotalCost(int qty, float cost)
    {
    	return qty*cost;
    }
    
    public void checkStock()
    {
        if(qty<=0)
            System.out.println("Out of stock");
        else if(qty<10)
            System.out.println("Running out of stock!\nQuantity: "+qty);
        else
            System.out.println("Available: "+qty);
    }
    
    /*public void billDisplay()
    {
    
    	int i;
    	float total=0;
    	System.out.println("***************************************");
        System.out.println("ID                : "+getId());
        System.out.println("Name              : "+getName());
        System.out.println("Diagnosis         : "+getDisease());
        System.out.println("Consulting Doctor : "+getName());    
        System.out.println("---------------------------------------");
        System.out.println("PRESCRIPTION");
        System.out.println("Name:			Qty:		Cost:		Total Cost:			   ");
        for(i=0;i<drugs.length;i++)
        {
        	
        	System.out.println(getName()+"		"+getQty()+"		"+getCost()+"		"+getTotalCost(drugs[i].getQty(),drugs[i].getCost()));
        	total=total+getTotalCost(drugs[i].getQty(),drugs[i].getCost());
        	
        }
        System.out.println("													TOTAL: Rs. "+total);
        System.out.println("---------------------------------------");
        System.out.println("***************************************");

    }*/
    
}

class Patient extends Person
{
	
    private int age;
    private int i, medicines;
    Doctor doc;
    
    public Patient(int id, String name, char gender, int age, Doctor doc)
    {
        super(id,name,gender);
        this.age=age;
        this.doc=doc;
    }
    
    public int getAge()
    {
        return age;
    }
    
    public String getDoc()
    {
        return doc.getName();
    }
    
    public String getSpec()
    {
        return doc.getSpeciality();
    }
    
    /*public void prescription()
    {
    	Medicine drugs[] = new Medicine[medicine];
    	int validity;
    	System.out.println("Enter the number of medicines prescribed: ");
    	for(i=0;i<medicines;i++)
    	{
    		
    		System.out.println("Enter the name: ");
    		name=sc.nextLine();
    		System.out.println("Enter the supplier: ");
    		seller=sc.nextLine();
    		System.out.println("Enter the expiry date: ");
    		expdate=sc.nextLine();
    		validity=checkExp(expdate);
    		if(validity==1)
    		{
    			System.out.println("Medicine in stock!");
    		}
    		else if(validity==-1)
    		{
    			System.out.println("Medicine expired, need to restock!");
    			break;
    		}
    		else if(validity==0)
    		{
    			System.out.println("Medicine expires today, need to restock!");
    			break;
    		}
    		System.out.println("Enter the cost: ");
    		cost=sc.nextFloat();
    		System.out.println("Enter the quantity: ");
    		qty=sc.nextInt();
    		drugs[i] = new Medicine(String name, String seller, String expdate, Float cost, int qty);
    	
    	}
    	
    }*/
    
}

public class Hospital 
{	
    public static void main(String[] args) 
    {
        
	int i, j, d, s, p, m;
	int o;
        
	int id;
	String name;
	char gender;
	
	float basic;
	String timing;
	String speciality;
	String qualif;
	
	String desig;
	int hrs;
	float hwage;
	
	int age;
	
	String seller;
	String expdate;
	float cost;
	int qty;
	
	int choice;
	int echoice;
	
	Scanner sc = new Scanner(System.in);
        
    	System.out.println("************************************************************");
        System.out.println("                HOSPITAL MANAGEMENT");
    	System.out.println("************************************************************");
        
    	System.out.println("DOCTORS");
    	System.out.print("Enter the number of doctors: ");
    	d=sc.nextInt();
    	Doctor D[] = new Doctor[d+1];
    	for(i=0;i<d;i++)
    	{
    		
    		System.out.print("\nEnter the ID            : ");
    		id=sc.nextInt();
                
                sc.nextLine();
    		System.out.print("Enter the name          : ");
    		name=sc.nextLine();
    		System.out.print("Enter the gender        : ");
    		gender=sc.next().charAt(0);
                
                sc.nextLine();
    		System.out.print("Enter the timings       : ");
    		timing=sc.nextLine();
    		System.out.print("Enter the qualifications: ");
    		qualif=sc.nextLine();
    		System.out.print("Choose speciality    :\n1.General Physician\n2.Cardiologist\n3.Paediatrician\n4.Gynecologist\n5.Surgeon\n6.Dermatologist\n7.Neurologist\n");
    		o=sc.nextInt();
                switch(o)
                {
                    case 1:
                        speciality="General Physician";
                        break;
                    case 2:
                        speciality="Cardiologist";
                        break;
                    case 3:
                        speciality="Paediatrician";
                        break;
                    case 4:
                        speciality="Gynecologist";
                        break;
                    case 5:
                        speciality="Dermatologist";
                        break;
                    default:
                        speciality="Null";
                      
                 }
                
                
    		System.out.print("Enter the basic pay     : ");
    		basic=sc.nextFloat();
                
    		D[i] = new Doctor(id, name, gender, basic, timing, speciality, qualif);
                D[i].calSal();
    		
    	}
    	
    	/*System.out.println("STAFF");
    	System.out.println("Enter the number of staff: ");
    	s=sc.nextInt();
    	Staff S[] = new Staff[s];
    	for(i=0;i<s;i++)
    	{
    		
    		System.out.println("Enter the ID:");
    		id=sc.nextInt();
    		System.out.println("Enter the name: ");
    		name=sc.nextLine();
    		System.out.println("Enter the gender: ");
    		gender=sc.next().charAt(0);
    		System.out.println("Enter the designation: ");
    		desig=sc.nextLine();
    		System.out.println("Enter the hourly wage: ");
    		hwage=sc.nextFloat();
    		S[i] = new Staff(id, name, gender, desig, hwage);
    		
    	}*/
    	System.out.println("************************************************************");
    	
     	System.out.println("\nPATIENTS");
    	System.out.print("Enter the number of patients : ");
    	p=sc.nextInt();
    	Patient P[] = new Patient[p+1];
    	for(j=0;j<p;j++)
    	{
    		
    		System.out.print("\nEnter the ID          : ");
    		id=sc.nextInt();
                
                sc.nextLine();
    		System.out.print("Enter the name        : ");
    		name=sc.nextLine();
    		System.out.print("Enter the gender      : ");
    		gender=sc.next().charAt(0);
    		System.out.print("Enter the age         : ");
    		age=sc.nextInt();
                
                sc.nextLine();
    		System.out.print("Choose symptoms       : ");
    		System.out.println("\n1. Cold, cough, throat infection, fever, etc. \n2. Heart - Cardiovascular issues, breathing difficulties, chest pains \n3. Children (ages 0-15 years) \n4. Women - Pregnancy, etc. \n5. Skin and Hair - Rashes, hairfall, itchiness, dandruff, etc. \n");
                int op;
                op=sc.nextInt();
                Doctor doc=null;
                
                switch(op)
                {
                    case 1:
                        for(i=0;i<d;i++)
                        {
                            if(D[i].getSpeciality().equals("General Physician"))
                            {
                                doc=D[i];
                                //System.out.print(doc.getName());
                            }
                        }
                    break;
                    case 2:
                        for(i=0;i<d;i++)
                        {
                            if(D[i].getSpeciality().equals("Cardiologist"))
                            {
                                doc=D[i];
                            }
                        }
                    break;
                    case 3:
                        for(i=0;i<d;i++)
                        {
                            if(D[i].getSpeciality().equals("Paediatrician"))
                            {
                                doc=D[i];
                            }
                        }
                    break;
                    case 4:
                        for(i=0;i<d;i++)
                        {
                            if(D[i].getSpeciality().equals("Gynecologist"))
                            {
                                doc=D[i];
                            }
                        }
                    break;
                    case 5:
                        for(i=0;i<d;i++)
                        {
                            if(D[i].getSpeciality().equals("Dermatologist"))
                            {
                                doc=D[i];
                            }
                        }
                    break;
                        
                    default:
                        doc=null;
                }
            P[j] = new Patient(id, name, gender, age, doc);
        }
    	System.out.println("************************************************************");
    	
    	while(1==1)
    	{
    	
        	System.out.println("\nWhat would you like to do?");
        	System.out.println("1.View doctor details\n2.View patient details\n3.Generate payslip for an employee\n4.Exit");
    		choice=sc.nextInt();
    		switch(choice)
    		{
    		
    		case 1:
    			
                                System.out.print("\nEnter the ID: ");
    				id=sc.nextInt();
    				for(i=0;i<d;i++)
    				{
    					
    					if(id==D[i].getId())
    					{
    					
                                        System.out.println("************************************************************");
    				        System.out.println("Doctor ID              : "+D[i].getId());
    				        System.out.println("Doctor Name            : "+D[i].getName());
    				        System.out.println("Timings                : "+D[i].getTiming());
    				        System.out.println("Speciality             : "+D[i].getSpeciality());
    				        System.out.println("Salary                 : Rs."+D[i].netsal);
                                        System.out.println("************************************************************");
    					break;	
    					}
                                        
    					else
    					{
    						System.out.print("Doctor not found!");
    					}
                                }
                                break;
    					
    		case 2:
				System.out.println("\nEnter the ID: ");
				id=sc.nextInt();
				for(i=0;i<p;i++)
				{
					
					if(id==P[i].getId())
					{
					
                                        System.out.println("************************************************************");
				        System.out.println("Patient ID                            : "+P[i].getId());
				        System.out.println("Patient Name                          : "+P[i].getName());
				        System.out.println("Patient Age                           : "+P[i].getAge());
				        System.out.println("Patient's Doctor                      : "+P[i].getDoc());
                                        
				        System.out.println("Speciality of Doctor                  : "+P[i].getSpec());
                                        System.out.println("************************************************************");
					break;	
					}
					else
					{
						System.out.print("Patient not found!");
					}
					
				}
    			break;
    			
    		case 3:
    			
    				System.out.println("\nEnter the ID: ");
    				id=sc.nextInt();
    				for(i=0;i<d;i++)
    				{
    					
    					if(id==D[i].getId())
    					{
    						D[i].paySlip();
    					}
    					else
    					{
    						System.out.print("Doctor not found!");
    					}
    					
    				}
    				
                                break;
    			
    		/*case 4:
    			System.out.print("Enter the ID: ");
    			id=sc.nextInt();
    			for(i=0;i<p;i++)
    			{
    				
    				if(id==P[i].id)
    				{
    					
    					P[i].billDisplay();
    					
    				}
    				else
    				{
    					System.out.println("Patient not found!");
    				}
    				
    			}
    			break;*/
    			
            case 4: 
            	System.exit(0);
            	break;

            }

    	}
    	    	
    }
    
}