import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler

import requests._

class RestQueryFunction extends RequestHandler[String, String] {

  def handleRequest(input: String, context: Context): String = {
    val response =
      requests.get("https://jsonplaceholder.typicode.com/todos/1").text()
    response
  }
}
