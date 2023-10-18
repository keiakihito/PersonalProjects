import pandas as pd
import matplotlib.pyplot as plt

# Load the CSV file into a DataFrame
data = pd.read_csv('AverageTime.csv')

# Extract the required columns
# mthd1: classical multiplication
# mthd2: divideConquer
# mthd3: strassen
# Size of matrix 2 by 2 to 2048 by 2048
colVecSizeOfMtx = data.iloc[0:12, 0]   # Rows 2 to 12, Column 1
colVecMthd1 = data.iloc[0:12, 1]  # Rows 2 to 12, Column 2
colVecMthd2 = data.iloc[0:12, 2]  # Rows 2 to 12, Column 3
colVecMthd3 = data.iloc[0:12, 3]  # Rows 2 to 12, Column 4


# Create the plot
plt.figure(figsize=(10, 12))

# Plot classical multiplication in red
plt.plot(colVecSizeOfMtx, colVecMthd1, 'ro-', label='classical multiplication', markersize=8, markerfacecolor='red')

# Plot divideConquer in blue
plt.plot(colVecSizeOfMtx, colVecMthd2, 'bo-', label='divideConquer', markersize=8, markerfacecolor='blue')

# Plot strassen in green
plt.plot(colVecSizeOfMtx, colVecMthd3, 'go-', label='strassen', markersize=8, markerfacecolor='green')

# Customize the plot
plt.xlabel('Size of Matrix, N by N, N = 2^k')
plt.ylabel('Time (milliseconds)')
plt.title('Plot of classical multiplication, divideConquer, and strassen execution average time ')
plt.legend()

# Create a legend with colored boxes
legend_labels = ['classical multiplication', 'divideConquer', 'strassen']
legend_colors = ['red', 'blue', 'green']
legend_patches = [plt.Line2D([0], [0], marker='o', color='w', label=label, markersize=8, markerfacecolor=color) for label, color in zip(legend_labels, legend_colors)]
plt.legend(handles=legend_patches)

# Show the plot
plt.grid()


# Set the y-axis limit
plt.ylim(500, 500000)


# Save the plot as a PDF file
plt.savefig('plot_output.pdf', format='pdf')

plt.show()

