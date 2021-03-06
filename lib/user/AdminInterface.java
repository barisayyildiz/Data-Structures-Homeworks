package lib.user;

import lib.furniture.*;
import lib.*;

public interface AdminInterface {

	boolean addBranch();
	boolean removeBranch(int branchId);

	boolean addBranchEmployee(int branchId, String name, String surname, int employeeId);
	boolean removeBranchEmployee(int branchId, String name, String surname, int employeeId);

	Company getCompany();
	
}
