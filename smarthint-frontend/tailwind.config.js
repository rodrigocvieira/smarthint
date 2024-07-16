const flowbite = require("flowbite-react/tailwind");

/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{js,jsx,ts,tsx}",
    flowbite.content(),
  ],
  theme: {
    extend: {
      colors: {
        primary: "#0086FF",
        white: "#FFFFFF",
        gray_my: "#B0A6A6"
      },
      fontFamily: {
        'body': ['"Roboto"']
      },
      fontSize: {
        "bold-header": ["32px" , {
          fontWeight: 'bold'
        }],
        "bold-grid-header": ["16px" , {
          fontWeight: 'bold'
        }],
        "semi-bold": ["16px" , {
          fontWeight: '600'
        }],
      }
    }
    
  },
  plugins: [flowbite.plugin()],
}

