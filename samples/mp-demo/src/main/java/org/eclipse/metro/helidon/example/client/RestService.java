/*
 * Copyright (c) 2021, 2023 Oracle and/or its affiliates. All rights reserved.
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

package org.eclipse.metro.helidon.example.client;

import com.dataaccess.webservicesserver.NumberConversion;
import com.dataaccess.webservicesserver.NumberConversionSoapType;
import java.math.BigDecimal;
import java.math.BigInteger;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/rest")
@RequestScoped
public class RestService {

    private NumberConversionSoapType port = new NumberConversion().getNumberConversionSoap();

    @GET
    @Path("/toDollars")
    @Produces(MediaType.TEXT_PLAIN)
    public String toDollars(@QueryParam("number") String n) {
        String number = (n == null || n.trim().isEmpty())
                ? "777"
                : n;
        String dollars = port.numberToDollars(new BigDecimal(number));
        return number + " == " + dollars;
    }

    @GET
    @Path("/toWords")
    @Produces(MediaType.TEXT_PLAIN)
    public String toWords(@QueryParam("number") String n) {
        String number = (n == null || n.trim().isEmpty())
                ? "321"
                : n;
        String dollars = port.numberToWords(new BigInteger(number));
        return number + " == " + dollars;
    }

}
