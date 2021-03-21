

def findMin(arr):

	if len(arr) < 0:
		raise Exception("Lenght cannot be 0")

	minVal = arr[0]

	for i in range(1,len(arr)):
		if arr[i] < minVal:
			minVal = arr[i]

	return minVal

def bubbleSort(arr): 
	n = len(arr) 

	for i in range(n): 
		for j in range(0, n-i-1): 
			if arr[j] > arr[j+1] :
				temp = arr[j] 
				arr[j] = arr[j+1]
				arr[j+1] = temp
				
	return arr

def median(arr):
	arr = bubbleSort(arr)

	length = len(arr)

	if length % 2 == 0:
		#even
		return ( arr[int(length/2)] + arr[int(length/2) - 1] ) / 2
	else:
		#odd
		return ( arr[int(length/2)])

	print(int(len(arr)/2))
	print(len(arr)/2)

def twoSums(arr, val):
	arr = bubbleSort(arr)

	i=0
	j=len(arr)-1

	while i<j:

		if arr[i] + arr[j] == val:
			print(arr[i], arr[j])
			return 1
		elif arr[i] + arr[j] < val:
			i+=1
		elif arr[i] + arr[j] > val:
			j-=1
	
	return 0

def mergeList(arr, arr2):

	length = len(arr)
	length2 = len(arr2)
	counter = 0
	counter2 = 0
	temp = []

	while (counter != length and counter2 != length2):

		if arr[counter] <= arr2[counter2]:
			temp.append(arr[counter])
			counter += 1
		elif arr[counter] > arr2[counter2]:
			temp.append(arr2[counter2])
			counter2 += 1
	
	while counter != length:
		temp.append(arr[counter])
		counter += 1

	while counter2 != length2:
		temp.append(arr2[counter2])
		counter2 += 1

	return temp

