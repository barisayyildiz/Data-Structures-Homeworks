import lib.furniture.*;
import lib.user.*;
import lib.*;

public class Main
{
	public static void main(String args[])
	{
		// List<Integer> l1 = new List<Integer>();

		// l1.insert(2);
		// l1.insert(4);
		// l1.insert(6);

		// l1.remove(1);

		// System.out.println(l1);

		Company c1 = new Company();

		Admin admin = c1.getAdmin();

		admin.addBranch();
		admin.addBranch();
		admin.addBranch();
		admin.addBranch();
		admin.removeBranch(1);

		admin.addBranchEmployee(new Employee(0, "john", "doe", "johndoe@gmail.com", "123", 0));
		admin.addBranchEmployee(new Employee(1, "john", "doe", "johndoe@gmail.com", "123", 0));
		admin.addBranchEmployee(new Employee(2, "john", "doe", "johndoe@gmail.com", "123", 2));

		admin.removeBranchEmployee(1);

		System.out.println(c1);





	}
}

