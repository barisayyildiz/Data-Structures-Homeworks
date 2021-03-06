package lib.user;

import lib.furniture.*;
import lib.*;

public interface AdminInterface {

	boolean addBranch();
	boolean removeBranch(int branchId);

	boolean addBranchEmployee(Employee person);
	boolean removeBranchEmployee(int id);

	Company getCompany();
	
}
