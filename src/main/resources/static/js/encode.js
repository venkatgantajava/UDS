/**
 * 
 */

 
 
 // Helper class for holding 64-bit integers
function int64(msint_32, lsint_32) {
    this.highOrder = msint_32;
    this.lowOrder = lsint_32;
}

// Initial hash values (H)
var H = [
    new int64(0x6a09e667, 0xf3bcc908),
    new int64(0xbb67ae85, 0x84caa73b),
    new int64(0x3c6ef372, 0xfe94f82b),
    new int64(0xa54ff53a, 0x5f1d36f1),
    new int64(0x510e527f, 0xade682d1),
    new int64(0x9b05688c, 0x2b3e6c1f),
    new int64(0x1f83d9ab, 0xfb41bd6b),
    new int64(0x5be0cd19, 0x137e2179)
];

// Round constants (K)
var K = [
    new int64(0x428a2f98, 0xd728ae22),
    new int64(0x71374491, 0x23ef65cd),
    new int64(0xb5c0fbcf, 0xec4d3b2f),
    new int64(0xe9b5dba5, 0x8189dbbc),
    new int64(0x3956c25b, 0xf348b538),
    new int64(0x59f111f1, 0xb605d019),
    new int64(0x923f82a4, 0xaf194f9b),
    new int64(0xab1c5ed5, 0xda6d8118),
    new int64(0xd807aa98, 0xa3030242),
    new int64(0x12835b01, 0x45706fbe),
    new int64(0x243185be, 0x4ee4b28c),
    new int64(0x550c7dc3, 0xd5ffb4e2),
    new int64(0x72be5d74, 0xf27b896f),
    new int64(0x80deb1fe, 0x3b1696b1),
    new int64(0x9bdc06a7, 0x25c71235),
    new int64(0xc19bf174, 0xcf692694),
    new int64(0xe49b69c1, 0x9ef14ad2),
    new int64(0xefbe4786, 0x384f25e3),
    new int64(0x0fc19dc6, 0x8b8cd5b5),
    new int64(0x240ca1cc, 0x77ac9c65),
    new int64(0x2de92c6f, 0x592b0275),
    new int64(0x4a7484aa, 0x6ea6e483),
    new int64(0x5cb0a9dc, 0xbd41fbd4),
    new int64(0x76f988da, 0x831153b5),
    new int64(0x983e5152, 0xee66dfab),
    new int64(0xa831c66d, 0x2db43210),
    new int64(0xb00327c8, 0x98fb213f),
    new int64(0xbf597fc7, 0xbeef0ee4),
    new int64(0xc6e00bf3, 0x3da88fc2),
    new int64(0xd5a79147, 0x930aa725),
    new int64(0x06ca6351, 0xe003826f),
    new int64(0x14292967, 0x0a0e6e70),
    new int64(0x27b70a85, 0x46d22ffc),
    new int64(0x2e1b2138, 0x5c26c926),
    new int64(0x4d2c6dfc, 0x5ac42aed),
    new int64(0x53380d13, 0x9d95b3df),
    new int64(0x650a7354, 0x8baf63de),
    new int64(0x766a0abb, 0x3c77b2a8),
    new int64(0x81c2c92e, 0x47edaee6),
    new int64(0x92722c85, 0x1482353b),
    new int64(0xa2bfe8a1, 0x4cf10364),
    new int64(0xa81a664b, 0xbc423001),
    new int64(0xc24b8b70, 0xd0f89791),
    new int64(0xc76c51a3, 0x0654be30),
    new int64(0xd192e819, 0xd6ef5218),
    new int64(0xd6990624, 0x5565a910),
    new int64(0xf40e3585, 0x5771202a),
    new int64(0x106aa070, 0x32bbd1b8),
    new int64(0x19a4c116, 0xb8d2d0c8),
    new int64(0x1e376c08, 0x5141ab53),
    new int64(0x2748774c, 0xdf8eeb99),
    new int64(0x34b0bcb5, 0xe19b48a8),
    new int64(0x391c0cb3, 0xc5c95a63),
    new int64(0x4ed8aa4a, 0xe3418acb),
    new int64(0x5b9cca4f, 0x7763e373),
    new int64(0x682e6ff3, 0xd6b2b8a3),
    new int64(0x748f82ee, 0x5defb2fc),
    new int64(0x78a5636f, 0x43172f60),
    new int64(0x84c87814, 0xa1f0ab72),
    new int64(0x8cc70208, 0x1a6439ec),
    new int64(0x90befffa, 0x23631e28),
    new int64(0xa4506ceb, 0xde82bde9),
    new int64(0xbef9a3f7, 0xb2c67915),
    new int64(0xc67178f2, 0xe372532b),
    new int64(0xca273ece, 0xea26619c),
    new int64(0xd186b8c7, 0x21c0c207),
    new int64(0xeada7dd6, 0xcde0eb1e),
    new int64(0xf57d4f7f, 0xee6ed178),
    new int64(0x06f067aa, 0x72176fba),
    new int64(0x0a637dc5, 0xa2c898a6),
    new int64(0x113f9804, 0xbef90dae),
    new int64(0x1b710b35, 0x131c471b),
    new int64(0x28db77f5, 0x23047d84),
    new int64(0x32caab7b, 0x40c72493),
    new int64(0x3c9ebe0a, 0x15c9bebc),
    new int64(0x431d67c4, 0x9c100d4c),
    new int64(0x4cc5d4be, 0xcb3e42b6),
    new int64(0x597f299c, 0xfc657e2a),
    new int64(0x5fcb6fab, 0x3ad6faec),
    new int64(0x6c44198c, 0x4a475817)
];

// Message schedule (W)
var W = new Array(64);

// Helper functions for bitwise operations
function safe_add_2(x, y) {
    var lsw, msw, lowOrder, highOrder;
    lsw = (x.lowOrder & 0xFFFF) + (y.lowOrder & 0xFFFF);
    msw = (x.lowOrder >>> 16) + (y.lowOrder >>> 16) + (lsw >>> 16);
    lowOrder = lsw & 0xFFFF;
    highOrder = msw & 0xFFFF;
    return new int64(highOrder, lowOrder);
}

// Rotate right (right-rotate) for 64-bit integers
function rotr(x, n) {
    var low = x.lowOrder;
    var high = x.highOrder;
    return new int64(((low >>> n) | (high << (64 - n))) & 0xFFFFFFFFFFFFFFFF, (high >>> n) | (low << (64 - n)));
}

// Add, XOR, OR functions for working with 64-bit words
function sigma0(x) {
    return rotr(x, 28);
}

function sigma1(x) {
    return rotr(x, 34);
}

function gamma0(x) {
    return rotr(x, 1);
}

function gamma1(x) {
    return rotr(x, 19);
}

function maj(x, y, z) {
    return new int64((x.highOrder & y.highOrder) ^ (x.highOrder & z.highOrder) ^ (y.highOrder & z.highOrder),
        (x.lowOrder & y.lowOrder) ^ (x.lowOrder & z.lowOrder) ^ (y.lowOrder & z.lowOrder));
}

function ch(x, y, z) {
    return new int64((x.highOrder & y.highOrder) ^ (~x.highOrder & z.highOrder),
        (x.lowOrder & y.lowOrder) ^ (~x.lowOrder & z.lowOrder));
}

// Step 1: Preprocess input message and padding (including length encoding)
function str2binb(str) {
    var bin = [];
    var length = str.length * 8;
    for (var i = 0; i < length; i += 8) {
        bin[i >> 5] |= (str.charCodeAt(i / 8) & 0xFF) << (24 - i % 32);
    }
    return bin;
}

// Final SHA-512 hash function (returns the hash as a hexadecimal string)
function sha512(message) {
    var messageLength = message.length;
    var messageBytes = str2binb(message);
    messageBytes[messageLength >> 5] |= 0x80 << (24 - messageLength % 32);
    messageBytes[((messageLength + 128 >> 10) << 5) + 31] = messageLength;

    var hash = H.slice(0); // Make a copy of the initial hash values

    // Process message in 1024-bit blocks
    for (var i = 0; i < messageBytes.length / 1024; i++) {
        var block = messageBytes.slice(i * 1024 / 32, (i + 1) * 1024 / 32);
        W = [];
        
        // Prepare message schedule (W)
        for (var j = 0; j < 16; j++) {
            W[j] = new int64(block[j * 2], block[j * 2 + 1]);
        }

        // Extend the message schedule for 80 rounds
        for (var j = 16; j < 80; j++) {
            W[j] = safe_add_2(sigma1(W[j - 2]), safe_add_2(W[j - 7], sigma0(W[j - 15])));
        }

        // Initialize working variables
        var a = hash[0];
        var b = hash[1];
        var c = hash[2];
        var d = hash[3];
        var e = hash[4];
        var f = hash[5];
        var g = hash[6];
        var h = hash[7];

        // Main loop of 80 rounds
        for (var j = 0; j < 80; j++) {
            var t1 = safe_add_2(h, safe_add_2(ch(e, f, g), safe_add_2(K[j], W[j])));
            var t2 = safe_add_2(sigma1(a), maj(a, b, c));
            h = g;
            g = f;
            f = e;
            e = safe_add_2(d, t1);
            d = c;
            c = b;
            b = a;
            a = safe_add_2(t1, t2);
        }

        // Add the compressed block to the current hash value
        hash[0] = safe_add_2(a, hash[0]);
        hash[1] = safe_add_2(b, hash[1]);
        hash[2] = safe_add_2(c, hash[2]);
        hash[3] = safe_add_2(d, hash[3]);
        hash[4] = safe_add_2(e, hash[4]);
        hash[5] = safe_add_2(f, hash[5]);
        hash[6] = safe_add_2(g, hash[6]);
        hash[7] = safe_add_2(h, hash[7]);
    }

    // Convert hash to hexadecimal string
    return hash.map(function(x) {
        return (x.highOrder >>> 0).toString(16).padStart(8, '0') + (x.lowOrder >>> 0).toString(16).padStart(8, '0');
    }).join('');
}





// Function to encode a string using SHA-512
function encodeUsingSHA512(inputString) {
    // Call the sha512 function with the input string
    alert('inputString----------->'+inputString);
    var hash = sha512(inputString);
    console.log("SHA-512 Hash:", hash);
        alert('hash----------->'+hash);
            document.getElementById("hashedText").innerText = hash;

    return hash;
}

// Example usage
var input = document.getElementById("inputText").value;
var encodedHash = encodeUsingSHA512(input);
// document.getElementById("hashedText").value(encodedHash);