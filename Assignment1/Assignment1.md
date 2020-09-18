#### Design a course management system (Like Canvas)

- Professor
  - Data: loginCredentials, name
  - Behavior: logIn, logOut, accountNumber, createAssignment, markAssignment, giveAnnouncement 

- Student
  - Data: loginCredentials, studentID, name, 
  - Behavior: logIn, selectCourse, selectAssignment, submitFinishedAssignment, resubmitAssignment, checkGrade

- CourseManagementSystem
  - Data: courses,  name
  - Behavior: authenticate, chechCourse, rejectSubmission

- Course
  - Data: courseID, courseName, assignments, students, professors, grade

- Assignment
  - Data: assignmentName, dueDate, grade

```pseudocode
Sequence of invoking behaviors on objects
Professor civa;
CourseManagementSystem canvas;
civa.login(loginCredentials);
canvas.authenticate(loginCredentials);
Course course = civa.selectCourse(courseName);
Assignment assignment = civa.createAssignment(assignmentName, dueDate, grade);
if assignment looks good
	civa.submitAssignment(assignment, course);
	canvas.checkAssignment(assignment, courseID);
	if assignmentName is unique in the selected course
		course.sendNewAssignmentNoticification
	else
		canvas.rejectSubmission();
	if dueDate has passed
		civa.markAssignment(assignmentName);
		course.sendGradeNotification;
else modify the assignment


​```pseudocode
Sequence of invoking behaviors on objects
Student joyce;
CourseManagementSystem canvas;
joyce.login(loginCredentials);
canvas.authenticate(loginCredentials);
Course course = joyce.selectCourse(courseName);
if there is pending assignment for the course
	Assignment assignment1 = joyce.selectAssignment(assignmentName);
	if joyce finish the assignment
		joyce.submitFinishedAssignment(course, assignmentName);
		if submitDate <= dueDate
			course.submitAssignment(studentId, assignmentName);
			if joyce modify her assignment
				joyce.resubmitFinishedAssignment(assignment1);
				course.resubmitAssignment(studentId, assignmentName);
		else
			canvas.rejectSubmission()
		if joyce got notice about grade
			joyce.checkGrade(assignmentName);
	else
		fail this assignment;
else
	no active assigments;
	
```



#### Design a pet adoption platform

- PetAdopter
  - Data: name, emailAddress, creditScore, address, criminalRecord, proofOfFinancialAbility, keepPet, returnPet,
  - Behavior: selectPet, requestAdoption,  cancelRequest

- Pet
  - Data：petName, color, size, breed, 
  - Behavior

- PetAdoptionPlatform
  - Data: pets
  - Behavior：checkAdopterBackground, sendAdoptionAgreement, acceptAdoptionRequest, rejectAdoptionRequest, sendToShipper, followUpPet, 

- DeliveryServiceCompany
  - Data: Couriers
  - Behavior: allocateCourier, ship

- Courier
  - Data: Name
  - Behavior: deliverPet, contactCustomer

```pseudocode
Sequence of invoking behaviors on objects
petAdopter: bella;
petAdoptionPlatform: petLover;
deliveryServiceCompany: petTransfer;
Pet bubble = bella.selectPet(petName, color, size, breed);
if bubble isAvailable
	bella.requestAdoption(bubble);
	petLover.checkAdopterBackground(bella.creditScore, bella.address, bella.criminalRecord, 		bella.proofOfFinancialAbility);
	if bella isCapable
  	petLover.acceptRequest(bubble, bella);
  	petLover.sendAdoptionAgreement(bella.emailAddress);
	else
		petLover.rejectAdoptionRequest(bubble, bella);
		if bella sign the agreement
			petLover.sendToShipper(bubble, petTransfer);
			petTransfer.ship(bubble);
			Courier young = petTransfer.allocateCourier;
			young.contactCustomer(bella);
			young.deliverPet(bubble, bella.address);
		else petLover.rejectAdoptionRequest(bubble, bella);
			if bella get along with bubble
				bella.keepPet(bubble);
			else bella.returnPet(bubble, petLover);				
else bubble isNotAvailable;	

```

#### Design an app to book airline ticket

- Customer
  - Data: loginCredentials,  accoutnNumber, emailAddress, creditCard, passportInformation, address, 
  - Behavior: longIn, bookTicket, searchTicket, selectTicket, requestCancelTicket, 

- TicketApp
  - Data: airlineCompany, tickets
  - Behavior: findTickets, showAvailableTickets, checkOut, addMemberReward, deductMemberReward, chargeCancellationFee, refund

- AirlineCompany
  - Data: companyName,
  - Behavior: checkOut, issueTicket, sendReceipt, 

- Ticket
  - Data: ticketNumber, price, airlineCompany, flightNumber, departure, destination, departureDate, returnDate, seatClass, price, ticketNumber



```pseudocode
Sequence of invoking behaviors on objects
//Process of customer booking tickets 
Customer joyce;
ticketApp expedia;
airlineCompany Delta;
joyce.login(loginCredentials);
ticket[] toCalifornia = joyce.searchTicket(departure, destination, departureDate, returnDate, seatClass);
if there are tickets available
	ticketApp.showAvailableTickets(toCalifornia[]);
	if joyce is satisfied with one ticket
		joyce.selectTicket(toCalifornia[i]);
		joyce.bookTicket(toCalifornia[i]);
		ticketApp.checkOut(joyce.emailAddress, joyce.creditCard, joyce.address)；
		ticketApp.addMembershipReward(joyce.accountNumber);
		if joyce change her mind
			joyce.cancelTicket(toCalifornia[i]);
			ticketApp.chargeCancellationFee(joyce.creditCard);
			ticketApp.refund(joyce.creditCard);
			ticketApp.deductMembershipReward(joyce.accountNumber); 	
	else 
		joyce quitApp;
else 
	ticketsNotFound;
	
```



#### Design a course registration platform

- Student
  - Data: name, studentId, LoginCredentials, 
  - Behavior: logIn, logOut, searchCourse, registerCourse, cancelRegistration, joinWaitlist, 
- CourseManagementSystem
  - Data: courses 
- Behavior: addStudentToCourseList, addStudentToWaitList, removeStudentFromWaitList, removeStudentToCourseList,
- Course
  - Data: couseID, courseName, classTiming, availableSeats, registeredStudentList, waitList,  

```pseudocode
Sequence of invoking behaviors on Objects
Student Joyce;
CourseManagementSystem MyNEU;
Joyce.logIn(loginCredentials);
Course info5100 = Joyce.searchCourse(courseID, courseName, session);
if info5100.availableSeats > 0
	Joyce.registerCourse(info5100);
	MyNEU.addStudentToCourseList(Joyce.name, Joyce.studentId, info5100.rigisteredStudentList);
	if Joyce change her mind
				Joyce.cancelRegistration(info5100);
				MyNEU.removeStudentFromCourseList(Joyce.name, Joyce.studentId,
        info5100.registeredStudentList);
else
  Joyce.joinWaitlist(info5100);
  MyNEU.addStudentToWaitlist(Joyce, info5100.waitList);
    if Joyce successfully get a place;
      MyNEU.removeStudentFromWaitlist(Joyce.name, Joyce.student, info5100.waitList);
      MyNEU.addStudentToCourseList(Joyce.name, Joyce.studentId, 
      info5100.registeredStudentList);
  	else 
  		courseNotAvailable; 
		
```

 

#### Order food in a food delivery app(like Uber Eats)

- Customer
  - Data: userName, password, name, address, phoneNumber, creditCard, emailAddress, 
  - Behavior: createAccount, logIn, orderFood, writeReview, requestCancelOrder, addTipsToRestaurant,  
- Restaurant
  - Data: menu, price, address, 
  - Behavior:
- FoodDeliveryApp
  - Data: restaurants, dishes, 
  - Behavior: checkOut, sendReceipt, acceptCancelOrder, rejectCancelOrder, refund, chargeTips, allocateCourier,
- Order
  - Data: orderNumber, 
- Food
  - Data: type, flavor,  
- Courier
  - Data: name, 
  - Behavior: contactCustomer, deliverFood,

```pseudocode
Sequence of invoking behaviors on Objects
Customer Joyce;
FoodDeliveryApp uberEats;
Food friedChicken;
Restaurant ChiMac;
Joyce.createAccount(userName, password, name, address, phoneNumber);
Joyce.logIn(userName, password);
Food friedChicken = Joyce.searchFood(food.type, food.flavor, restaurant.name);
if ChiMac has the food Joyce want
	Order orderNumber = Joyce.orderFood(friedChicken, ChiMac);
	uberEats.checkOut(Joyce.address, Joyce.phone, Joyce.creditCard);
	uberEats.sendReceipt(orderNumber, joyce.emailAddress);
	if Joyce change her mind
		Joyce.requestCancelOrder(orderNumber);
		if uberEats agree cancellation
			uberEats.acceptCancelOrder(orderNumber);
			uberEats.refund(joyce.creditCard);
		else
			uberEats.rejectCancelOrder(orderNumber);
  else
  	uberEats.sendToShipper(ChiMac.address, orderNumber, Joyce.address, Joyce.phoneNumber);
  	Courier Young = uberEats.allocateCourier;
  	Young.contactCustomer(Joyce);
  	Young.deliverFood(friedChicken, Joyce.address);
			if Joyce satisfied with the food
				Joyce.writeReview("very tasty");
				Joyce.addTipsToRestaurant(ChiMac);
				UberEats.chargeTips(Joyce.creditCard);
			else
				Joyce would not buy that again;		
else food not available;;

```

 