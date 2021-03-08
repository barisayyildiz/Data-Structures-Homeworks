public class Test {

	public static void main(String args[])
	{
		func1();

	} 

	public static void func1()
	{
		try
		{
			func2();
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}

	public static void func2()
	{
		func3();
	}

	public static void func3() throws Exception
	{
		throw new Exception("hata!!!!");
	}
	
}

