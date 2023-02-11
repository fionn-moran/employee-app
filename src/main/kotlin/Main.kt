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

    var input : Int

    do {
        input = menu()
        when(input) {
            1 -> println("Monthly Salary: ${getMonthlySalary()}")
            2 -> println("Monthly PRSI: ${getMonthlyPRSI()}")
            3 ->println("Monthly PAYE: ${getMonthlyPAYE()}")
            4 -> println("Monthly Gross Pay: ${getGrossMonthlyPay()}")
            5 -> println("Monthly Total Deductions: ${getTotalMonthlyDeductions()}")
            6 -> println("Monthly Net Pay: ${getNetMonthlyPay()}")
            7 -> println(getPayslip())
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
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

fun menu() : Int {
    print("""
        Employee Menu for ${getFullName()}
           1. Monthly Salary
           2. Monthly PRSI
           3. Monthly PAYE
           4. Monthly Gross Pay
           5. Monthly Total Deductions
           6. Monthly Net Pay
           7. Full Payslip
          -1. Exit
         Enter Option : """)
    return readLine()!!.toInt()
}