/***
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.twostepsfromjava.cloud.service.user.api;

import io.twostepsfromjava.cloud.user.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import io.twostepsfromjava.cloud.service.user.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import io.twostepsfromjava.cloud.product.dto.Product;

import java.util.List;


/**
 * User API服务
 *
 * @author CD826(CD826Dong@gmail.com)
 * @since 1.0.0
 */
@RestController
@RequestMapping("/users")
public class UserEndpoint {
    protected Logger logger = LoggerFactory.getLogger(UserEndpoint.class);

    @Value("${server.port:2200}")
    private int serverPort = 2200;

    @RequestMapping(value = "/{loginName}", method = RequestMethod.GET)
    public User detail(@PathVariable String loginName) {
        this.logger.info("======request login name is======= "+loginName);
        String memos = "I come form " + this.serverPort;
        /*try{
            Thread.sleep(1000000);
        }catch ( Exception e){
            this.logger.error("+++++++++ error ++++++++++",e);
        }*/
        return new User(loginName, loginName, "/avatar/default.png", memos);
    }

    /*@RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> list() {
        return productService.findAll();
    }

    @RequestMapping(value = "/products/{itemCode}", method = RequestMethod.GET)
    public Product detailV2(@PathVariable String itemCode) {
        return productService.loadByItemCode(itemCode);
    }
*/
    public String helloFallback() {

        return "Hello Failure !";
    }
}
