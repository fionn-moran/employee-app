
class Employee (var firstName: String, var surname: String, var gender: Char, var employeeID: Int,
    var grossSalary: Double, var payePercentage: Double, var prsiPercentage: Double,
    var annualBonus: Double, var cycleToWorkSchemeMonthlyDeduction: Double)

fun getFullName() = when (employee.gender){
    'm', 'M' -> "Mr. ${employee.firstName} ${employee.surname}"
    'f', 'F' -> "Ms.  ${employee.firstName} ${employee.surname}"
    else ->  "${employee.firstName} ${employee.surname}"
}
fun getMonthlySalary() = roundToTwo(employee.grossSalary / 12)

fun getMonthlyPRSI() = roundToTwo(getMonthlySalary() * (employee.prsiPercentage / 100))
fun getMonthlyPAYE() = roundToTwo(getMonthlySalary() * (employee.payePercentage / 100))
fun getGrossMonthlyPay() = roundToTwo(getMonthlySalary() + (employee.annualBonus / 12))
fun getTotalMonthlyDeductions() = roundToTwo((getMonthlyPRSI() + getMonthlyPAYE() + employee.cycleToWorkSchemeMonthlyDeduction))
fun getNetMonthlyPay() = roundToTwo(getGrossMonthlyPay() - getTotalMonthlyDeductions())

fun getMonthlyBonus() = roundToTwo(employee.annualBonus / 12)

fun getPayslip() {

    val monthlySalary = roundToTwo(employee.grossSalary / 12)
    val monthlyPrsi = roundToTwo(monthlySalary * (employee.prsiPercentage / 100))
    val monthlyPaye = roundToTwo(monthlySalary * (employee.payePercentage / 100))
    val monthlyBonus = roundToTwo((employee.annualBonus / 12))
    val grossPay = roundToTwo((monthlySalary + (employee.annualBonus / 12)))
    val totalDeductions = roundToTwo((monthlyPrsi + monthlyPrsi + employee.cycleToWorkSchemeMonthlyDeduction))
    val netPay = roundToTwo((grossPay - totalDeductions))

    println(
        """
         Monthly Payslip for: ${getFullName()}
        ______________________________________________________________________
         Employee's Full Details: ${employee.firstName.uppercase()} ${employee.surname.uppercase()} (${employee.gender.uppercase()}), ID: $employee.employeeID                  
        ______________________________________________________________________    
              PAYMENT DETAILS:                                                                    
                   Salary: ${getMonthlySalary()}
                   Bonus:  ${getMonthlyBonus()}   
                          
                   Gross Pay = ${getGrossMonthlyPay()}
        ______________________________________________________________________
              DEDUCTION DETAILS:      
                   PAYE: ${getMonthlyPAYE()}                
                   PRSI: ${getMonthlyPRSI()}  
                   Cycle To Work Scheme Deduction: $employee.cycleToWorkSchemeMonthlyDeduction   
                   
                   Total Deductions = ${getTotalMonthlyDeductions()}
        ______________________________________________________________________
              NET PAY: $netPay (Gross Pay - Total Deductions)
        ______________________________________________________________________"""
    )
}