import scala.actors._
import scala.actors.Actor._

class Account(val accountNumber: Int, val balance: Int){}

object Bank extends Actor{
    
    val totalAccounts = 10000
    
    private var transferCount = 0
    
    private var accounts = Map[Int, Account]()
    
    for(i <- 0 until totalAccounts){
        accounts = accounts + (i -> new Account(i, 1000))
    }
    
    val beginningBalance = (for(a <- accounts.values) yield a.balance).foldLeft(0)(_ + _)
    println("Beginning Balance: " + beginningBalance)
    
    def act = {
        loop{
            receive{
                case ("get_account", accountNumber: Int) => reply(accounts(accountNumber))
                case ("all_acounts") => reply(accounts)
                case ("transfer", fromNumber: Int, toNumber: Int, amount: Int) =>
                    val from = accounts(fromNumber)
                    val fromAfterTransfer = new Account(from.accountNumber, from.balance - amount)
                    accounts = accounts + (fromAfterTransfer.accountNumber -> fromAfterTransfer)
                    
                    val to = accounts(toNumber)
                    val toAfterTransfer = new Account(to.accountNumber, to.balance + amount)
                    accounts = accounts + (toAfterTransfer.accountNumber -> toAfterTransfer)

                    transferCount = transferCount + 1
                    if(transferCount % 100000 == 0) println("Transfers so far: " + transferCount)
                    if(transferCount == 1000000){
                        val finalBalance = (for(a <- accounts.values) yield a.balance).foldLeft(0)(_ + _)
                        println("Final Balance: " + finalBalance)
                    }
                    sender ! "go"
            }
        }
    }
}

class Member extends Actor{
    
    private var transferCount = 0;
    
    private val random = new java.util.Random
    
    def act = {
        loop{
            react{
                case "go" =>
                    if(transferCount < 10000){
                        transferCount = transferCount + 1
                        val fromNumber = random.nextInt(Bank.totalAccounts)
                        val toNumber = random.nextInt(Bank.totalAccounts)
                        Bank ! ("transfer", fromNumber, toNumber, random.nextInt(100))
                    }
            }
        }
    }
}

object ActorsExample{
    def main(args: Array[String]){
        Bank.start
        for(_ <- 1 to 100){
            new Member().start ! "go"
        }
    }
}