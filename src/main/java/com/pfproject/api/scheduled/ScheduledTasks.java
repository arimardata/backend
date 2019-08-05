// package com.pfproject.api.scheduled;

// import java.awt.List;
// import java.text.ParseException;

// /*
// * Copyright 2012-2015 the original author or authors.
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// * https://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */

// import java.text.SimpleDateFormat;
// import java.time.LocalDateTime;
// import java.util.ArrayList;
// import java.util.Date;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.scheduling.annotation.Scheduled;
// import org.springframework.stereotype.Component;

// import com.pfproject.api.model.Cheque;
// import com.pfproject.api.service.ChequeService;

// import com.pfproject.api.service.ChequeService;

// @Component
// public class ScheduledTasks {

// private static final Logger log =
// LoggerFactory.getLogger(ScheduledTasks.class);

// private static final SimpleDateFormat dateFormat = new
// SimpleDateFormat("HH:mm:ss");

// private ChequeService service;
// @Scheduled(fixedRate = 5000)
// public void reportCurrentTime() {
// log.info("The time is now {}", dateFormat.format(new Date()));
// }
// @Scheduled(fixedRate = 5000)
// /* public void Verify_cheques() throws ParseException {
// log.info("The time is now {}", dateFormat.format(new Date()));

// java.util.List<Cheque> L=(java.util.List<Cheque>) new List();
// L=service.findAll();
// ()
// Date date1=new SimpleDateFormat("yyyy/MM/dd").parse(saved.getDate());
// LocalDateTime now = LocalDateTime.now();
// Date current = new SimpleDateFormat ("yyyy/MM/dd").parse(now.toString());
// if(date1.getTime()-current.getTime()<=0) {
// SendEmail mail =new SendEmail();
// //mail.SendMail(from, to);
// }

// }*/

// }