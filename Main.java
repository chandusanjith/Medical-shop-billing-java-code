import java.util.Scanner;

class Bank
{
	private String accno;
	private String name;
	private long balance;

	Scanner KB=new Scanner(System.in);
	
	//method to open an account
	void openAccount()
	{ 
		System.out.print("Enter Medicine No: ");
		accno=KB.next();
		System.out.print("Enter Medicine Name: ");
		name=KB.next();
		System.out.print("Enter Medicine Balance: ");
		balance=KB.nextLong();
	}

	//method to display account details
	void showAccount()
	{ 
		System.out.println(accno+","+name+","+balance);
	}

	//method to deposit money
	void deposit()
	{
		long amt;
		System.out.println("Enter Number of Medicine U Want to Deposit : ");
		amt=KB.nextLong();
		balance=balance+amt;
	}

	//method to withdraw money
	void withdrawal()
	{
		long amt;
		System.out.println("Enter Number of Medicines U Want to withdraw : ");
		amt=KB.nextLong();
		if(balance>=amt)
		{ 
			balance=balance-amt;
		}
		else
		{
			System.out.println("Less Balance..Transaction Failed..");
		}
	}

	//method to search an account number
	boolean search(String acn)
	{ 
		if(accno.equals(acn))
		{ 
			showAccount();
			return(true);
		}
		return(false);
	}
}

class Main
{  
	public static void main(String arg[])
	{
		Scanner KB=new Scanner(System.in);
		
		//create initial accounts
		System.out.print("How Many Medicines U Want to Input : ");
		int n=KB.nextInt();
		Bank  C[]=new Bank[n];
		for(int i=0;i<C.length;i++)
		{   
			C[i]=new Bank();
			C[i].openAccount();
		}
		
		//run loop until menu 5 is not pressed
		int ch;
		do
		{
			System.out.println("Main Menu 1.Display 2.Search 3.Add Medicines 4.Deduct Medicines 5.Exit");
			System.out.println("Ur Choice :");
			ch=KB.nextInt();
			switch(ch)
			{ 
				case 1:
					for(int i=0;i<C.length;i++)
					{
						C[i].showAccount();
					}
					break;

				case 2:
					System.out.print("Enter Medicine number No U Want to Search...: ");
					String acn=KB.next();
					boolean found=false;
					for(int i=0;i<C.length;i++)
					{  
						found=C[i].search(acn);
						if(found)
						{
							break;
						}
					}
					if(!found)
					{
						System.out.println("Search Failed..Medicine number Not Exist..");
					}
					break;

				case 3:
					System.out.print("Enter Medicine number : ");
					acn=KB.next();
					found=false;
					for(int i=0;i<C.length;i++)
					{  
						found=C[i].search(acn);
						if(found)
						{
							C[i].deposit();
							break;
						}
					}
					if(!found)
					{
						System.out.println("Search Failed..Medicine number doesnt Exist..");
					}
					break;

				case 4:
					System.out.print("Enter Medicine number : ");
					acn=KB.next();
					found=false;
					for(int i=0;i<C.length;i++)
					{  
						found=C[i].search(acn);
						if(found)
						{
							C[i].withdrawal();
							break;
						}
					}
					if(!found)
					{
						System.out.println("Search Failed..Medicine number Not Exist..");
					}
					break;

				case 5:
					System.out.println("Good Bye..");
					break;
			}
		}
		while(ch!=5);
	}
}