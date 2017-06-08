/**
  * Created by Fraser on 08/06/2017.
  */

import scala.collection.mutable.ListBuffer

object Main {

  def calculatePrimeNumbers(): Unit ={
    var primes:ListBuffer[Int]=ListBuffer()

    for(currentNumber<-2 to 3000000){
      var noMatch = true
      var currentPrime = 1
      while(currentPrime<primes.size && noMatch){
        if(currentNumber % primes(currentPrime) == 0)
          noMatch=false
        currentPrime+=1
      }
      if(noMatch){
        primes+=currentNumber
        println(currentNumber)
      }

    }
  }

  def calculatePrimeNumbers(upTo : Int): Unit ={
    var primeNumbers = generateNumberList(upTo)
    var counter : Int =0

    //for each number in the list remove the item if it isnt a prime number
    while(primeNumbers.size!=0 && counter < primeNumbers.size){
      //don't bother checking for 1
      if(primeNumbers(counter)!=1){
        var i : Int = primeNumbers(counter)+1//no point comparing it to itself
        while(i<primeNumbers.size){
          var deleted : Boolean = false
          if(primeNumbers(i) % primeNumbers(counter) == 0)
            {
              primeNumbers.remove(i)
              deleted = true
            }
          if(!deleted)
            i+=1
        }
      }
      println(primeNumbers(counter))
      counter+=1
    }
  }

  def generateNumberList(amount : Int): ListBuffer[Int] = {
    var numberList : ListBuffer[Int] = ListBuffer()

    //fill the list buffer with numbers
    for(i<-1 to amount)
      numberList+=i

    numberList
  }

  def main(args : Array[String]): Unit ={
    calculatePrimeNumbers()
  }
}
