import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics
import org.apache.commons.rng.simple.RandomSource
import org.apache.commons.rng.sampling.distribution.GaussianSampler
import org.apache.commons.rng.sampling.distribution.MarsagliaNormalizedGaussianSampler

object SkewDistribution extends App {
  val gauss = new GaussianSampler(
    MarsagliaNormalizedGaussianSampler.of(RandomSource.MT_64.create()),
    50,
    15)
  val gaussRands = for(_ <- 1 to 100) yield gauss.sample()
  val gaussStats = new DescriptiveStatistics(gaussRands.toArray)
  val gaussMedian = gaussStats.getMean
  val gaussSd = gaussStats.getStandardDeviation
  println(s"Median: $gaussMedian")
  println(s"Standard deviation: $gaussSd")
}
