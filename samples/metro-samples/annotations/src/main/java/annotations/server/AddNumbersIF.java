/*
 * Copyright (c) 2021, 2023 Oracle and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package annotations.server;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.WebResult;
import jakarta.jws.WebParam;

@WebService(targetNamespace = "http://duke.example.org", name="AddNumbers")
@SOAPBinding(style=SOAPBinding.Style.RPC, use=SOAPBinding.Use.LITERAL)
public interface AddNumbersIF {
    
    @WebMethod(operationName="add", action="urn:addNumbers")
    @WebResult(name="return")
    public int addNumbers(
        @WebParam(name="num1")int number1, 
        @WebParam(name="num2")int number2) throws AddNumbersException;

}
