package datagen

import com.github.javafaker._
import java.io.File
import java.io.PrintWriter
import java.time.temporal.ChronoUnit.DAYS
import java.time._
import scala.util.Random

object DataGen {
    def main(args: Array[String]): Unit = {      
        val d = new Generator("file1.csv",1000)
        d.gen()
    }
  }

class Generator(_filename: String, _num_rows: Int) {
    var filename: String = _filename
    var num_rows: Int = _num_rows
    val faker: Faker = new Faker()
    val random = new Random(System.nanoTime)

    /* Generates a random date between two dates */
    def randDate(from: LocalDate, to: LocalDate): LocalDate = {
        val diff = DAYS.between(from, to)
        from.plusDays(random.nextInt(diff.toInt))
    }

    /* Given the filename and the number of rows from the class constructor,
       generate fake data and save to a csv file */
    def gen(): Unit = {
        val writer = new PrintWriter(new File(this.filename))
        writer.write(s"date, campaign_name, address, clicks, impressions, page_name \n")
        for(i <- 1 to this.num_rows){
          var campaign_name = faker.company.catchPhrase()
          var address = faker.address.streetAddress(true)
          var start: LocalDate = LocalDate.of(2016,1,1)
          var end: LocalDate = LocalDate.of(2016,12,31)
          var date: LocalDate = this.randDate(start, end)
          var clicks: Int = random.nextInt(1000)
          var impressions: Int = random.nextInt(1000000)
          var page_name = faker.internet.url()
          writer.write(s"$date, $campaign_name, $address, $clicks, $impressions, $page_name \n")
        }
        writer.close()
    }
}
