import kotlin.math.round

var employee =  Employee("Joe", "Soap", 'm', 6143, 67543.21, 38.5, 5.2, 1450.50, 54.33)
fun main(args: Array<String>) {

    add()

    var input: Int

    do {
        input = menu()
        when (input) {
            1 -> println("Monthly Salary: ${getMonthlySalary()}")
            2 -> println("Monthly PRSI: ${getMonthlyPRSI()}")
            3 -> println("Monthly PAYE: ${getMonthlyPAYE()}")
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



// https://discuss.kotlinlang.org/t/how-do-you-round-a-number-to-n-decimal-places/8843
fun roundToTwo(number: Double) = round(number * 100) / 100

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

fun add() {
    print("Enter first name: ")
    val firstName = readLine().toString()
    print("Enter surname: ")
    val surname = readLine().toString()
    print("Enter gender (m/f): ")
    val gender = readLine()!!.toCharArray()[0]
    print("Enter employee ID: ")
    val employeeID = readLine()!!.toInt()
    print("Enter gross salary: ")
    val grossSalary = readLine()!!.toDouble()
    print("Enter PAYE %: ")
    val payePercentage = readLine()!!.toDouble()
    print("Enter PRSI %: ")
    val prsiPercentage = readLine()!!.toDouble()
    print("Enter Annual Bonus: ")
    val annualBonus = readLine()!!.toDouble()
    print("Enter Cycle to Work Deduction: ")
    val cycleToWorkMonthlyDeduction = readLine()!!.toDouble()

    employee = Employee(
        firstName,
        surname,
        gender,
        employeeID,
        grossSalary,
        payePercentage,
        prsiPercentage,
        annualBonus,
        cycleToWorkMonthlyDeduction
    )
}

