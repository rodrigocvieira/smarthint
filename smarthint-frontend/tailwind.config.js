/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{js,jsx,ts,tsx}",
  ],
  theme: {
    colors: {
      primary: "#0086FF",
      white: "#FFFFFF",
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
  },
  plugins: [],
}

