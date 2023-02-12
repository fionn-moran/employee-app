
class Employee (var firstName: String, var surname: String, var gender: Char, var employeeID: Int,
    var grossSalary: Double, var payePercentage: Double, var prsiPercentage: Double,
    var annualBonus: Double, var cycleToWorkSchemeMonthlyDeduction: Double)

fun getFullName() = when (gender){
    'm', 'M' -> "Mr. ${firstName} ${surname}"
    'f', 'F' -> "Ms.  ${firstName} ${surname}"
    else ->  "${firstName} ${surname}"
}
fun getMonthlySalary() = roundToTwo(grossSalary / 12)

fun getMonthlyPRSI() = roundToTwo(getMonthlySalary() * (prsiPercentage / 100))
fun getMonthlyPAYE() = roundToTwo(getMonthlySalary() * (payePercentage / 100))
fun getGrossMonthlyPay() = roundToTwo(getMonthlySalary() + (annualBonus / 12))
fun getTotalMonthlyDeductions() = roundToTwo((getMonthlyPRSI() + getMonthlyPAYE() + cycleToWorkSchemeMonthlyDeduction))
fun getNetMonthlyPay() = roundToTwo(getGrossMonthlyPay() - getTotalMonthlyDeductions())

fun getMonthlyBonus() = roundToTwo(annualBonus / 12)

fun getPayslip() {

    val monthlySalary = roundToTwo(grossSalary / 12)
    val monthlyPrsi = roundToTwo(monthlySalary * (prsiPercentage / 100))
    val monthlyPaye = roundToTwo(monthlySalary * (payePercentage / 100))
    val monthlyBonus = roundToTwo((annualBonus / 12))
    val grossPay = roundToTwo((monthlySalary + (annualBonus / 12)))
    val totalDeductions = roundToTwo((monthlyPrsi + monthlyPrsi + cycleToWorkSchemeMonthlyDeduction))
    val netPay = roundToTwo((grossPay - totalDeductions))

    println(
        """
         Monthly Payslip for: ${getFullName()}
        ______________________________________________________________________
         Employee's Full Details: ${firstName.uppercase()} ${surname.uppercase()} (${gender.uppercase()}), ID: $employeeID                  
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
              NET PAY: $netPay (Gross Pay - Total Deductions)
        ______________________________________________________________________"""
    )
}