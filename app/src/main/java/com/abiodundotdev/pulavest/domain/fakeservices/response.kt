package com.abiodundotdev.pulavest.domain.fakeservices

import com.abiodundotdev.pulavest.domain.models.Investment
import com.abiodundotdev.pulavest.domain.models.User

class FakeResponse {
    companion object {
        val user : User = User(id = 1,
            fullname =  "qazeem abiodun",
            email = "abiodundotdev@gmail.com",
            phone_no = 12321212321,
            wallet_balance = 23223,
            address = "Lekki nigeria",
            first_name = "Qazeem",
            last_name = "Abiodun",
            wallet_id = "232",
            is_email_verified = 0,
            status = 1,
            trans_pin = 21323,
            device_id = "samsung",
            last_login = "2023-03-07T12:32:09.306677Z",
            updated_at = "2023-03-07T12:32:09.306677Z",
            created_at = "2023-03-07T12:32:09.306677Z",
            email_verified_at = "2023-03-07T12:32:09.306677Z"
        );
        val investment : Investment = Investment( id = 1,
            name = "Lekki farm",
            percentage = 10,
            duration = 10,
            current_investors = 10,
            rio = 10,
            image_url = "image",
            start_date = "2023-04-07T12:32:09.306677Z",
            end_date = "2023-04-07T12:32:09.306677Z",
            date = "2023-04-07T12:32:09.306677Z",
            description = "hose in leeki",
            address = "lekki",
            amount = 10000,
        );
    }
}

//val investResponse = "{\n" +
//        "\"id\" : 1\n" +
//        "\"name\" : \"Olugbon maize investment\",\n" +
//        "\"percentage\" : 10,\n" +
//        "\"duration\" : 10,\n" +
//        "\"current_investors\" : 10,\n" +
//        "\"rio\" : 15,\n" +
//        "\"image_url\" : \"https://media.istockphoto.com/id/168351414/photo/green-cornfield-ready-for-harvest-late-afternoon-light-sunset-illinois.jpg?s=1024x1024&w=is&k=20&c=GUUFScqDcwtAhDFX9y9ETSJ7FxQT0BNlmPfZiiUutGQ=\",\n" +
//        "\"amount\" : 10000000,\n" +
//        "\"start_date\" : \"2023-03-07T12:32:09.306677Z\",\n" +
//        "\"end_date\" : \"2023-04-07T12:32:09.306677Z\",\n" +
//        "\"date\" : \"2023-07-07T12:32:09.306677Z\",\n" +
//        "\"description\" : \"Planting of 1 million maize hectares of land at olugbon market, lekki\"\n" +
//        "\"address\" : \"Lekki phase one, lekki\"\n" +
//        "},";

//val jsonResponse = "{\n" +
//        "        \"id\": 86,\n" +
//        "        \"fullname\": \"Adegoke adelani\",\n" +
//        "        \"email\": \"abiodundotdev@gmail.com\",\n" +
//        "        \"phone_no\": 8103963814,\n" +
//        "        \"wallet_id\": \"1234\",\n" +
//        "        \"address\": \"1234\",\n" +
//        "        \"first_name\": \"Adelani\",\n" +
//        "        \"last_name\": \"Adegoke\",\n" +
//        "        \"wallet_balance\": 305,\n" +
//        "        \"is_email_verified\": 1,\n" +
//        "        \"status\": 1,\n" +
//        "        \"trans_pin\": 123456,\n" +
//        "        \"device_id\": \"9023CF76-D792-4925-BD77-ED6B5DD3CED9\",\n" +
//        "        \"last_login\": \"2023-03-07T12:32:09.306677Z\",\n" +
//        "        \"created_at\": \"2022-01-15T12:42:03.000000Z\",\n" +
//        "        \"updated_at\": \"2023-03-07T12:32:09.000000Z\"\n" +
//        "    }";