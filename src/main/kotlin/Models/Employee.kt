package Models

import roundToTwo

class Employee (var firstName: String, var surname: String, var gender: Char, var employeeID: Int,
    var grossSalary: Double, var payePercentage: Double, var prsiPercentage: Double,
    var annualBonus: Double, var cycleToWorkSchemeMonthlyDeduction: Double) {

    fun getFullName() = when (gender) {
        'm', 'M' -> "Mr. ${firstName} ${surname}"
        'f', 'F' -> "Ms.  ${firstName} ${surname}"
        else -> "${firstName} ${surname}"
    }

    fun getMonthlySalary() = roundToTwo(grossSalary / 12)

    fun getMonthlyPRSI() = roundToTwo(getMonthlySalary() * (prsiPercentage / 100))
    fun getMonthlyPAYE() = roundToTwo(getMonthlySalary() * (payePercentage / 100))
    fun getGrossMonthlyPay() = roundToTwo(getMonthlySalary() + (annualBonus / 12))
    fun getTotalMonthlyDeductions() =
        roundToTwo((getMonthlyPRSI() + getMonthlyPAYE() + cycleToWorkSchemeMonthlyDeduction))

    fun getNetMonthlyPay() = roundToTwo(getGrossMonthlyPay() - getTotalMonthlyDeductions())

    fun getMonthlyBonus() = roundToTwo(annualBonus / 12)

    fun getPayslip() =
        """
         Monthly Payslip for: ${getFullName()}
        ______________________________________________________________________
         Models.Employee's Full Details: ${firstName.uppercase()} ${surname.uppercase()} (${gender.uppercase()}), ID: $employeeID                  
        ______________________________________________________________________    
              PAYMENT DETAILS:                                                                    
                   Salary: ${getMonthlySalary()}
                   Bonus:  ${getMonthlyBonus()}   
                          
                   Gross Pay = ${getGrossMonthlyPay()}
        ______________________________________________________________________
              DEDUCTION DETAILS:      
                   PAYE: ${getMonthlyPAYE()}                
                   PRSI: ${getMonthlyPRSI()}  
                   Cycle To Work Scheme Deduction: $cycleToWorkSchemeMonthlyDeduction   
                   
                   Total Deductions = ${getTotalMonthlyDeductions()}
        ______________________________________________________________________
              NET PAY: ${getNetMonthlyPay()} (Gross Pay - Total Deductions)
        ______________________________________________________________________"""

    override fun toString(): String {
        return "Models.Employee(firstName='$firstName', surname='$surname', gender=$gender, employeeID=$employeeID, grossSalary=$grossSalary, payePercentage=$payePercentage, prsiPercentage=$prsiPercentage, annualBonus=$annualBonus, cycleToWorkSchemeMonthlyDeduction=$cycleToWorkSchemeMonthlyDeduction)"
    }


}