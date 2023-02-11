import kotlin.math.round

val firstName = "Joe"
val surname = "Soap"
val gender = "M"
val employeeID = 6143
val grossSalary = 67543.21
val payePercentage = 38.5
val prsiPercentage = 5.2
val annualBonus = 1450.50
val cycleToWorkSchemeMonthlyDeduction = 54.33

fun main(args: Array<String>) {
    println("Pay Slip Printer")
    printPayslip()

    //Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}

fun printPayslip() {

    val monthlySalary = roundToTwo(grossSalary / 12)
    val monthlyPrsi = roundToTwo(monthlySalary * (prsiPercentage / 100))
    val monthlyPaye = roundToTwo(monthlySalary * (payePercentage / 100))
    val monthlyBonus = roundToTwo((annualBonus / 12))
    val grossPay = roundToTwo((monthlySalary + (annualBonus / 12)))
    val totalDeductions = roundToTwo((monthlyPrsi + monthlyPrsi + cycleToWorkSchemeMonthlyDeduction))
    val netPay = roundToTwo((grossPay - totalDeductions))

    println("-------------------------------------------------------------------")
    println("| Employee Monthly Payslip                                        |")
    println("|-----------------------------------------------------------------|")
    println("|                                                                 |")
    println("| Employee Name: ${firstName.uppercase()} ${surname.uppercase()}     Gender: ${gender.uppercase()}     Employee ID: ${employeeID}     |")
    println("|                                                                 |")
    println("|-----------------------------------------------------------------|")
    println("|                                                                 |")
    println("| Payment Details                         Deduction Details       |")
    println("|                                                                 |")
    println("|-----------------------------------------------------------------|")
    println("| Salary: ${monthlySalary}          PAYE: ${monthlyPaye}     |")
    println("| Bonus: ${monthlyBonus}                          PRSI: ${monthlyPrsi}               |")
    println("|                                     Cycle to Work: ${cycleToWorkSchemeMonthlyDeduction}        |")
    println("|                                                                 |")
    println("|-----------------------------------------------------------------|")
    println("| Gross: ${grossPay}                     Total Deductions: ${totalDeductions}    |")
    println("|                                                                 |")
    println("|-----------------------------------------------------------------|")
    println("|                    NET PAY: ${netPay}                             |")
    println("|                                                                 |")
    println("|-----------------------------------------------------------------|")
}

// https://discuss.kotlinlang.org/t/how-do-you-round-a-number-to-n-decimal-places/8843
fun roundToTwo(number: Double) = round(number * 100) / 100