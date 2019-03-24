package Movies

object MoviesRelevance {
    def main(args: Array[String]): Unit = {
      Logger.getLogg("org").setLevel(Level.OFF)

      val conf = new SparkConf().setAppName("Test").setMaster("local[2]")
      val sc = new SparkContext(conf)
      val rddFichier = sc.textFile("C:/.../fichierNbAmis.txt")

      val rddSansEntete = rddFichier.mapPartitionsWithIndex { (idx, iter) =>
        if (idx == 0) iter.drop(1)
        else iter
      }

    }
}
