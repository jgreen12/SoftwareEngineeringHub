//PseudoCode for Software Engineering
//Author: Charles Miller

Begin MemberVerificationClass
public function checkMemberValidity(memberId)
	open ActorDatabase file
	begin loop do while(not end of file)
		begin if (memberID is present)
			return true
		end if
	end do while
	return false
end checkMemberValidity()		
			
begin class ModifyActors
public function newActor(actorInfo)
	open ActorDatabase file
	begin if(!checkMemberValidity(actorInfo))
		print "Actor already present"
		return
	end if
	write actorInfo to ActorDatabase file
	print "Actor Added"
	close ActorDatabase file
end method newActor()

public function removeActor(actorInfo)
	open ActorDatabase file
	begin if(checkMemberValidity(actorInfo))
		delete matching data from ActorDatabase
		print "Actor Removed"
	end if
	close ActorDatabase file
end method removeActor()

public function alterActor(actorInfo)
	open ActorDatabase file
	begin if (checkMemberValidity(actorInfo))
		input alterations
		write alterations to ActorDatabase file
	end if
	close ActorDatabase file
end alterActor()


begin class Enroll
public function enroll(actorInfo)
	begin if (checkMemberValidity(actorInfo))
		display unenroll button
	else
		display enroll button
	end if
	user inputs selection
	call Message class public function sendMessage(selection)
end enroll()
end Enroll

begin class ChocAnSystem
public member function main()
display log in page
user enters information
user presses button "Log in" or "Log in as guest"
begin if(actor is manager)
	print manager page
	begin if(print weekly services button is pressed)
		call class WeeklyServices member function printWeeklyServices()
	end if
	begin if(print claims button is pressed)
		call class Claims member function printClaims()
	end if
else if(actor is member)
	print member page
	begin if (enroll button is pressed)
		call class Enroll member function enroll()
	end if
	begin if(request services button is pressed)
		call class Services member function RequestServices()
	end if
	begin if(pay fee button is pressed)
		call class PayFee member function paySelectFees()
	end if
else if(actor is provider)
	print provider page
	begin if(Verify member button is pressed)
		input actorInfo
		call class MemberVerification member function checkMemberValidity(actorInfo)
	end if
	begin if(check messages button is pressed)
		call class Message member function printMessages()
	end if
else if(actor is operator)
	print operator page
	begin if(Verify member button is pressed)
		input actorInfo
		call class MemberVerification member function checkMemberValidity(actorInfo)
	end if
	begin if(add actor button is pressed)
		input actorInfo
		call class ModifyActors member function addActor(actorInfo)
	end if
	begin if(remove actor button is pressed)
		input actorInfo
		call class ModifyActors member function removeActor(actorInfo)
	end if
	begin if(alter actor button is pressed)
		input actor info
		begin if(checkMemberValidity())
			input newInfo
			call class ModifyActors member function modifyActor(newInfo)
		end if
	end if
else if(actor is guest)
	print guest page
	begin if(Enroll button is pressed)
		input data
		call class Enroll member function enroll(data)
	end if
end if
end main()
end ChocAnSystem

begin class Claims
public function printClaims()
	open claims file
	begin do while(not end of file)
		output current line
	end do while
end printClaims
end Claims