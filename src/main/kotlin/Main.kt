import kotlin.math.round

val firstName = "Joe"
val surname = "Soap"
val gender = 'm'
val employeeID = 6143
val grossSalary = 67543.21
val payePercentage = 38.5
val prsiPercentage = 5.2
val annualBonus = 1450.50
val cycleToWorkSchemeMonthlyDeduction = 54.33

fun main(args: Array<String>) {
    println("Pay Slip Printer")
    println(getFullName())
    println("Monthly Salary: ${getMonthlySalary()}")
    println("Monthly PRSI: ${getMonthlyPRSI()}")
    println("Monthly PAYE: ${getMonthlyPAYE()}")
    println("Monthly Gross Pay: ${getGrossMonthlyPay()}")
    println("Monthly Total Deductions: ${getTotalMonthlyDeductions()}")
    println("Monthly Net Pay: ${getNetMonthlyPay()}")
    println("Monthly Bonus: ${getMonthlyBonus()}")
    println(getPayslip())


    //Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}

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



// https://discuss.kotlinlang.org/t/how-do-you-round-a-number-to-n-decimal-places/8843
fun roundToTwo(number: Double) = round(number * 100) / 100

fun getFullName() = when (gender) {
    'm', 'M' -> "Mr. $firstName $surname"
    'f', 'F' -> "Ms. $firstName $surname"
    else -> "$firstName $surname"
}

fun getMonthlySalary() = roundToTwo(grossSalary / 12)

fun getMonthlyPRSI() = roundToTwo(getMonthlySalary() * (prsiPercentage / 100))
fun getMonthlyPAYE() = roundToTwo(getMonthlySalary() * (payePercentage / 100))
fun getGrossMonthlyPay() = roundToTwo(getMonthlySalary() + (annualBonus / 12))
fun getTotalMonthlyDeductions() = roundToTwo((getMonthlyPRSI() + getMonthlyPAYE() + cycleToWorkSchemeMonthlyDeduction))
fun getNetMonthlyPay() = roundToTwo(getGrossMonthlyPay() - getTotalMonthlyDeductions())

fun getMonthlyBonus() = roundToTwo(annualBonus / 12)