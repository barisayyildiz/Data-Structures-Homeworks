public class Test {

	public static void main(String args[])
	{
	
		Point p1 = new Point(3,4);
		Point o1 = new Point(3,5);
		System.out.println(p1.equals(o1));


	} 
	
}

class A
{

}


class Point
{
	private int x;
	private int y;
	
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public int getX(){return this.x;}
	public int getY(){return this.y;}


	@Override
	public boolean equals(Object o)
	{
		boolean result = true;
		
		try {

			Point temp = (Point)o;

			// System.out.println(temp.getX());
			// System.out.println(temp.getY());

			if(temp.getX() == this.x && temp.getY() == this.y)
				result = true;
			else
				result = false;
			
		} catch (Exception e) {
			
			result = false;
		}finally
		{
			return result;
		}
	}

}
