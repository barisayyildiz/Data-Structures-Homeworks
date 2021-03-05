package lib.user;

public interface AdminInterface {

	boolean addBranch(int branchId);
	boolean removeBranch(int branchId);

	boolean addBranchEmployee(int branchId, String name, String surname, int employeeId);
	boolean removeBranchEmployee(int branchId, String name, String surname, int employeeId);
	
}
