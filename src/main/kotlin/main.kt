

    fun main(){
        var myAccount=CurrentAccount("6767767","Nyawera",120000.0)
        myAccount.deposit(5000.0)
        myAccount.withdraw(100.5)


        var mySavingsAccount=SavingsAccount("980898998","Tut",90000.5,7)
        mySavingsAccount.deposit(8000.5)
        mySavingsAccount.withdraw(5000.5)

        var sanitaries=Product("soap",50.0,1000.5,"hygiene")
        var school=Product("pen",5.5,30.5,"other")
        var vegetables=Product("cabbage",20.5,60.0,"groceries")

        assignProducts(sanitaries)
        assignProducts(school)
        assignProducts(vegetables)

        evenIndices("mawera")
        evenIndices("kawera")


    }
    open class CurrentAccount(var accountNumber:String,var accountName:String,var balance:Double){
        fun deposit(amount:Double){
            balance+=amount
            println(balance)
        }
        open fun withdraw(amount: Double){
            balance-=amount
            println(balance)
        }
        fun details(){
            println("Account number $accountNumber with balance $balance is operated by $accountName")
        }

    }
    class SavingsAccount(accountNumber: String,accountName: String,balance: Double, var withdrawals:Int):CurrentAccount(accountNumber,accountName,balance){
        override fun withdraw(amount: Double) {
            if (withdrawals<9){
                balance-=amount
            }
            println(balance)
            withdrawals++
        }
    }
    data class Product(var name:String, var weight:Double,var price:Double,var category:String)
    fun assignProducts(product:Product){

        var groceriesLists= mutableListOf<Product>()
        var hygieneLists= mutableListOf<Product>()
        var otherLists= mutableListOf<Product>()
        when(product.category){
            "groceries"-> groceriesLists.add(product)
            "hygiene"->hygieneLists.add(product)
            "other"->otherLists.add(product)
        }
        println( listOf(product))

    }
    fun evenIndices(word:String):String{
        var Hello=""
        word.forEachIndexed { index, x ->
            if (index%2==0){
                Hello+=x
            }
        }
        println(Hello)
        return Hello

    }

















//Assessment 2
//1.Create a classCurrentAccount with the following attributes:account
//number, account name, balance. It has the following functions:
//a.deposit(amount: Double) - Increments the balance bythe
//amount deposited
//b.withdraw(amount: Double) - Decrements the balanceby the
//amount withdrawn
//c.details() - Prints out the account number and balanceand
//name in this format: “Account number x with balance y is
//operated by z”(5points)
//2.Create another classSavingsAccount. It has the samefunctions and
//attributes as the current account except for one attribute,
//withdrawals: Int. Withdrawals is a counter variablethat is used to
//keep track of how many withdrawals have been made from the account
//in a year. The only other difference is that the savings account
//withdraw() method first checks if the number of withdrawalsis less
//than 4 for it to allow one to withdraw money from the account. It also
//increments the withdrawals attribute after a successful withdrawal
//(5points)
//3.A product is represented by a data class with these attributes: name,
//weight, price, category. Category can either be groceries, hygiene or
//other. Write a function that takes in a product and uses a when
//statement to assign each product to a list based on its category
//(3 points)
//4.Write a function that given a string returns a string composed of only
//the characters in even indices. For example given “banana” it will return
//“bnn”(2 points)