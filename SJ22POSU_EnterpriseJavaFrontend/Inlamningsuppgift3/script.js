const nums = document.querySelectorAll("input")
const form = document.querySelector("form")
var pin = "1qaz";
let inpin ="";

let firelarm = new Audio();
firelarm.src = "emergency-alarm-with-reverb-29431.mp3";
let thieflarm = new Audio();
thieflarm.src = "clock-alarm-8761.mp3";


nums.forEach((num, index) => {
    num.dataset.id = index
   

    num.addEventListener('keyup', () => {
        if (num.value.length == 1) {
            if (nums[nums.length - 1].value.length == 1) {
                alert('Hello there, sdsdsI am being submitted');
                 form.submit()
            }
            //console.log(nums[nums.length - 1].value.length)
            nums[parseInt(num.dataset.id) + 1].focus()
           inpin += num.value
           console.log(inpin)
        }
       
    })
})
console.log(inpin)

