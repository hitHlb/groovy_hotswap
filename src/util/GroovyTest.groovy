import main.EntranceForTest;

def change = {i->
	if(i >= 0){
		i = 1
	}else{
		i = -1
	}
	return i
}

EntranceForTest.num = change(EntranceForTest.num)

return EntranceForTest.num