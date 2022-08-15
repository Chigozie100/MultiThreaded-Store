package ProductsEntry;

import ProductsEntry.Enums.Role;
import ProductsEntry.Enums.Sex;

import static ProductsEntry.Enums.Role.APPLICANT;

public class Manager extends Employees{
    Role newRole;
    Sex sex;

    public Manager(String employeeName, int employeeId, Role newRole, Sex sex) {
        super(employeeName, employeeId);
        this.newRole = newRole;
        this.sex = sex;
    }

}
