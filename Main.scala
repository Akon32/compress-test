object Main extends App {
	
	def encode[A](arr:Seq[A]) = {
		import scala.collection.mutable
		val es = mutable.HashMap[A,Int]()
		val data = mutable.Buffer[A]()
		val inds = arr map {a=>
			es get a  match{
				case Some(i)=>i
				case None =>
					val i = es.size
					es += a -> i
					data += a
					i
			}
		}
		(data.toSeq,inds)
	}
	
	val src = scala.io.Source.stdin.getLines.toBuffer
	val (data,inds)=encode(src)
	println(" data")
	data foreach println
	println(" inds")
	inds foreach println
//	println(s"encoded: data=$data inds=$inds")
//	println(s"decoded: ${inds map data}")
	
}



