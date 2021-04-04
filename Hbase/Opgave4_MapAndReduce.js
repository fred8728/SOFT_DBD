
//Map list of numbers to a list of their square roots: [1,9,16,100]
arr1 = [1,9,16,100]
result1 = arr1.map(x => Math.sqrt(x));
console.log("Square roots: " + result1);

// Map the list of words so each is wrapped in a ¡h1¿ tag: 
// [“Intro”, “Requirements”, “Analysis”, “Implementation”, “Conclusion”, “Discussion”, “References”]
arr2 = ['Intro', 'Requirements', 'Analysis', 'Implementation', 'Conclusion','Discussion','References'];
result2 = arr2.map(x => '<h1>' + x + '<h1/>')
console.log("Wrapped in h1 tag: " + result2);

// Use map to uppercase the words (all letters): [“i’m”, “yelling”, “today”]
arr3 = ['i’m','yelling','today'];
result3 = arr3.map(x => x.toUpperCase());
console.log("To uppercase: " + result3);

// Use map to transform words into their lengths: [“I”, “have”, “looooooong”,“words”]
arr4 = ['I','have','looooooong','words'];
result4 = arr4.map(x => x.length);
console.log("The length of words in array: " + result4);

// Get the json file comics.json from the course site. Paste it into your
// browser’s Javascript console. Use map to get all the image urls, and wrap
// them in img-tags.

//result5 = comics.map( x=> x);
//console.log("Image urls: " + result5);

// Use reduce to sum the array of numbers: [1,2,3,4,5]
arr5 = [1,2,3,4,5];

result6 = arr5.reduce(function(accumulator, currentValue) {
    return  accumulator + currentValue
});

console.log("Sum of array: " + result6);

// Use reduce to sum the x-value of the objects in the array: [{x: 1},{x:2},{x: 3}]
arr6 = [{x: 1},{x:2},{x: 3}];

result7 = arr6.reduce(function (acc, obj) { 
    return acc + obj.x; }, 0);

console.log("Sum of x-values: " + result7)

// Use reduce to flatten an array of arrays: [[1,2],[3,4],[5,6]]
arr7 = [[1,2],[3,4],[5,6]];

result7 = arr7.reduce(function(accumulator, currentValue) {
    return accumulator.concat(currentValue)
});

console.log("Flatten array of arrays: " + result7);

// Return an array of the positive numbers: [-3, -1, 2, 4, 5]
arr8 = [-3, -1, 2, 4, 5];
result8 = arr8.filter(function(val)  { 
    return val>=0
 });
console.log("Positive numbers in array: " + result8);